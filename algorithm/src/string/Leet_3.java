package string;

/**
 *给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3 
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *     请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 * 
 * 提示：
 *
 * 0 <= s.length <= 5 * 104
 * s由英文字母、数字、符号和空格组成
 *
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 *
 * */
public class Leet_3 {
    public static void main(String[] args) {
	  String s = "nfpdmpi";
	  int res = new Leet_3().lengthOfLongestSubstring(s);
	  System.out.println(res);
    }
    /**
     * ---框架4要点
     * 1、right 右移时，更新 array[i] 的大小
     * 2、left 右移时，更新array[i]的值
     * 3、窗口锁紧时机：array[i]>1
     * 4、更新结果时机: add时，取Math.max(right-left,len)
     * ---边界问题
     * 5、
     * */
    public int lengthOfLongestSubstring(String s) {
	  if (s == null || s.length() == 0) {
		return 0;
	  }
	  int[] array = new int[256];
	  int left = 0, right = left;
	  int len = 0;
	  while (right < s.length()) {
		char c = s.charAt(right);
		array[c]++;
		right ++;
		if (array[c] == 1) {
		    if (len < right-left) {
			  len = right - left;
		    }
		} else {
		    while (array[c] > 1) {
			  char c1 = s.charAt(left);
			  left++;
			  array[c1]--;
		    }
		}
	  }
	  return  len;
//	  return 0;
    }
}
