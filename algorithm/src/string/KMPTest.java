package string;

public class KMPTest {

    public static void main(String[] args) {
//        int[] arr = getNext("abcdabc");
//        for(int i :arr){
//		System.out.println(i);
//	  }
        String s1 = "ATGTGAGCTGGTGTGTGCFAA";
        String s2 = "GTGTGCF";
	  System.out.println(kmp(s1,s2));
//	  System.out.println(getNext());
    }
    static int kmp(String original,String patch){
        int j = 0;
        int[] arr = getNext(patch);
        for(int i = 0;i< original.length();i++){
            while (j>0 && patch.charAt(j) != original.charAt(i)){
                j = arr[j];
		}
            if(original.charAt(i) == patch.charAt(j)){
                j++;
		}
            if(j == patch.length()){
                return (i-patch.length()+1);
		}
	  }
        return -1;
    }

    static int[] getNext(String patch){
        int[] res = new int[patch.length()];
        int j = 0;
        for(int i=2;i< patch.length();i++){
            while (j>0 && patch.charAt(j) != patch.charAt(i-1)){
                j = res[j];
		}
            if(patch.charAt(i-1) == patch.charAt(j)){
                j++;
		}
            res[i] = j;
	  }
        return res;
    }
}
