package string;

import java.util.HashMap;
import java.util.Map;

/**
 *给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 示例 1：
 *
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 示例 2：
 *
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 
 * 提示：
 *
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 *
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 *
 * */
public class Leet_76 {
    /**
     * ------细节处理：
     * 1、注意map内存的 Integer 比较时，应该用 equals 而不是 ==
     * 2、另外为了节省内存，也可以用数组表示
     * 3、取结果时机，为 value == need.size,不符合条件则返回 “”
     * ------框架要点：
     * 1、right 右移时，更新 window[i] 和 valid 的大小
     * 2、left 右移时，window[i]和 valid的值
     * 3、窗口锁紧时机： valid == need.size ，退出条件为 valid < need.size
     * 4、更新结果时机: 窗口锁紧时，取Math.max(right-left,len)
     * */
    public String minWindow(String s, String t) {
	  Map<Character, Integer> need = new HashMap<>();
	  Map<Character, Integer> window = new HashMap<>();
	  for (char c : t.toCharArray()) {
		need.put(c, need.getOrDefault(c, 0) + 1);
	  }
	  int left = 0, right = left;
	  int valid = 0;
	  int len = Integer.MAX_VALUE;
	  int start = 0;
	  while (right < s.length()) {
		char c = s.charAt(right);
		right++;
		if (need.containsKey(c)) {
		    window.put(c, window.getOrDefault(c, 0) + 1);
		    if (window.get(c).equals(need.get(c))) {
			  valid++;
		    }
		}
		while (valid == need.size()) {
		    if (right - left < len) {
			  len = right - left;
			  start = left;
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
	  return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
