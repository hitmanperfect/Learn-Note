package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
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
 * **/
public class Leet_20 {
    public boolean isValid(String s) {
	  if(s == null || s.length() %2  == 1) return false;
	  Stack<Character> stack = new Stack();
	  Map<Character,Character> map = new HashMap(){
		{
		    put(')','(');put(']','[');put('}','{');
		}
	  };
	  for(Character c:s.toCharArray()){
		if(map.containsKey(c)){
		    if(stack.isEmpty() || stack.peek() != map.get(c)){
			  return false;
		    }else{
			  stack.pop();
		    }
		}else{
		    stack.push(c);
		}
	  }
	  return stack.isEmpty();
    }
}
