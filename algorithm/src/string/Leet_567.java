package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串s1和s2，写一个函数来判断 s2 是否包含 s1的排列。
 * <p>
 * 换句话说，第一个字符串的排列之一是第二个字符串的 子串 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 * <p>
 * 输入: s1= "ab" s2 = "eidboaoo"
 * 输出: False
 * <p>
 * 提示：
 * <p>
 * 输入的字符串只包含小写字母
 * 两个字符串的长度都在 [1, 10,000] 之间
 * <p>
 * 链接：https://leetcode-cn.com/problems/permutation-in-string
 */
public class Leet_567 {
    public static void main(String[] args) {
	  String s1 = "abcd";
	  String s2 = "abczdbac";
	  boolean res = new Leet_567().checkInclusion(s1, s2);
	  System.out.println(res);
    }

    /**
     * ---框架4要点
     * 1、right 右移时，更新 window[i] 和 valid 的值
     * 2、left 右移时， 更新 window[i] 和 valid 的值
     * 3、窗口缩紧时机：right-left == s1.length
     * 4、更新结果时机: valid == need.size
     * ---边界问题
     * 5、窗口缩紧时，right-left>=s1.length结果是一样的，但 > 不会发生作用，达到 ==条件时，
     * left+1 就不符合下次循环条件了
     * 6、可以在 !need.containsKey(c) 时直接更新 left 的值吗？
     * ANS:可以，如果直接更新 left = right,则窗口size 为 right -left = 0，应执行 window.size() 和 valid = 0
     * 一定程度上，减少时间复杂度，但可能出错，可将更新left 的时机改为 right-left == s1.length  时
     *
     * 7、由于当符合条件时，直接返回，所以 left++ 的操作放到了 else 中，正确逻辑不应该这样
     * */
    public boolean checkInclusion(String s1, String s2) {
	  if (s2 == null || s2.length() == 0 || s1 == null || s1.length() == 0) {
		return false;
	  }
	  Map<Character, Integer> need = new HashMap();
	  Map<Character, Integer> window = new HashMap();
	  for (char c : s1.toCharArray()) {
		need.put(c, need.getOrDefault(c, 0) + 1);
	  }
	  int left = 0, right = left;
	  int valid = 0;
	  while (right < s2.length()) {
		char c = s2.charAt(right);
		right++;
		if (need.containsKey(c)) {
		    window.put(c, window.getOrDefault(c, 0) + 1);
		    if (window.get(c).equals(need.get(c))) {
			  valid++;
		    }
		}
		/*else { //尽量将 更新left 时机，交给 right - left == s1.length
			left = right;
			window.clear();
			valid=0;
		}*/
		while (right - left == s1.length()) {
		    if (valid == need.size()) {
			  return true;
		    } /*else { ！！！！！！以下代码不应该放到 else 中
			  char c1 = s2.charAt(left);
			  left++;
			  if (need.containsKey(c1)) {
				if (window.get(c1).equals(need.get(c1))) {
				    valid--;
				}
				window.put(c1, window.get(c1) - 1);
			  }
		    }*/
		    char c1 = s2.charAt(left);
		    left++;
		    if (need.containsKey(c1)) {
			  if (window.get(c1).equals(need.get(c1))) {
				valid--;
			  }
			  window.put(c1, window.get(c1) - 1);
		    }
		}
	  }
	  return false;
    }
}
