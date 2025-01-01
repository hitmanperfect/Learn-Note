package defult;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 
 *
 * 示例 1：
 *
 * 输入：s = "()"
 * 输出：true
 * 示例2：
 *
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例3：
 *
 * 输入：s = "(]"
 * 输出：false
 * 示例4：
 *
 * 输入：s = "([)]"
 * 输出：false
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Leet_20 {
    public static void main(String[] args) {
        String s = "()";
	  boolean res = new Leet_20().isValid(s);
	  System.out.println(res);
    }
	/**
	 * 1、map 初始化时，传入的是 字符（‘{’），而不是字符串("{")
	 * */
    public boolean isValid(String s) {
	  if (s == null || s.length() %2 == 1) {
	      return false;
	  }
	  Map<Character,Character> map = new HashMap(){
		{
		    put('}','{');
		    put(')','(');
		    put(']','[');
		}
	  };
	  Stack<Character> stack = new Stack<>();
	  int index = 0;
	  while (index < s.length()) {
	      char c = s.charAt(index);
		if (map.containsKey(c)) {
		    if (stack.empty() || !stack.peek().equals(map.get(c))) {
			  return false;
		    } else {
			  stack.pop();
		    }
		} else {
		    stack.push(c);
		}
		index++;
	  }
	  return stack.size()==0;
    }
}
