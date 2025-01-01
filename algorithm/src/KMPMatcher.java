import java.util.ArrayList;
import java.util.List;

public class KMPMatcher {
    public List<Integer> findSubstring(String a, String b) {
        List<Integer> indices = new ArrayList<>();
        if (a == null || b == null || a.length() == 0 || b.length() < a.length()) {
            return indices;
        }

        int[] lps = computeLPSArray(a);
        int i = 0; // index for str
        int j = 0; // index for pat

        while (i < b.length()) {
            if (a.charAt(j) == b.charAt(i)) {
                j++;
                i++;
            }

            if (j == a.length()) {
                indices.add(i - j+a.length()-1); // add index
                j = lps[j - 1];
            } else if (i < b.length() && a.charAt(j) != b.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
        return indices;
    }

    private int[] computeLPSArray(String a) {
        int[] lps = new int[a.length()];
        int len = 0; // length of the previous longest prefix suffix

        lps[0] = 0; // lps[0] is always 0
        int i = 1;

        while (i < a.length()) {
            if (a.charAt(i) == a.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        KMPMatcher kmpMatcher = new KMPMatcher();
        String a = "ab";
        String b = "abcxabcdabcyabczabc";
        List<Integer> indices = kmpMatcher.findSubstring(a, b);
        System.out.println(indices); // Output: [0, 5, 9]
    }
}
