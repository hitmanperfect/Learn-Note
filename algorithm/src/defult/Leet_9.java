package defult;

/**
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 *
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：x = 121
 * 输出：true
 * 示例2：
 *
 * 输入：x = -121
 * 输出：false
 * 解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3：
 *
 * 输入：x = 10
 * 输出：false
 * 解释：从右向左读, 为 01 。因此它不是一个回文数。
 * 示例 4：
 *
 * 输入：x = -101
 * 输出：false
 *
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * **/
public class Leet_9 {

    /**
     * 字符串型的题，双指针即可
     * */
    public boolean isPalindrome(int x) {
	  if (x<0) {
	      return false;
	  }
	  String s = String.valueOf(x);
	  char[] chars = s.toCharArray();
	  int len = chars.length;
	  int left = 0,right = chars.length-1;
	  while (left < right) {
		if (chars[left] == chars[right]) {
		    left++;
		    right--;
		} else {
		    return false;
		}
	  }
	  return true;
    }
}
