package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串s和一个非空字符串p，找到s中所有是p的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串s和 p的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * 示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leet_438 {
    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
	  List<Integer> res = new Leet_438().findAnagrams(s,p);
	  System.out.println(res);
    }

    /**
     * ---框架4要点
     * 1、right 右移时，更新 window[i] 和 valid 的值
     * 2、left 右移时， 更新 window[i] 和 valid 的值
     * 3、窗口缩紧时机：right-left == s1.length
     * 4、更新结果时机: valid == need.size ,res.add[left]
     * ---边界问题
     * 注意该提是 s包含p，而 Leet_567 是 p 包含s，这俩参数顺序反了
     * */
    public List<Integer> findAnagrams(String s, String p) {
	  if (s == null || s.length() == 0) {
		return new ArrayList<Integer>();
	  }
	  Map<Character, Integer> need = new HashMap();
	  Map<Character, Integer> window = new HashMap();
	  for (char c : p.toCharArray()) {
		need.put(c, need.getOrDefault(c, 0) + 1);
	  }
	  int left = 0, right = left;
	  int valid = 0;
	  List<Integer> list = new ArrayList<>();
	  while (right < s.length()) {
		char c = s.charAt(right);
		right++;
		if (need.containsKey(c)) {
		    window.put(c, window.getOrDefault(c, 0) + 1);
		    if (window.get(c).equals(need.get(c))) {
			  valid++;
		    }
		}
//		else { //尽量将 更新left 时机，交给 right - left == s1.length
//			left = right;
//			window.clear();
//			valid=0;
//		}
		while (right - left == p.length()) {
		    if (valid == need.size()) {
		        list.add(left);
		    }
		    char c1 = s.charAt(left);
		    left++;
		    if (need.containsKey(c1)) {
			  if (window.get(c1).equals(need.get(c1))) {
				valid--;
			  }
			  window.put(c1, window.get(c1) - 1);
		    }
		}
	  }
	  return list;
    }
}
