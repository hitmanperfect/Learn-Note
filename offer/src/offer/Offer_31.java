package offer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 * 
 *
 * 示例 1：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 *
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 *
 * 提示：
 *
 * 0 <= pushed.length == popped.length <= 1000
 * 0 <= pushed[i], popped[i] < 1000
 * pushed是popped的排列。
 * 注意：本题与主站 946 题相同：https://leetcode-cn.com/problems/validate-stack-sequences/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Offer_31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
	  if (pushed == null && popped == null) return true;
	  if (pushed == null || popped == null || pushed.length != popped.length) return false;
	  Stack<Integer> s = new Stack<>();
	  int pushIndex = 0;
	  int popIndex = 0;
	  while (pushIndex < pushed.length) {
	      s.push(pushed[pushIndex++]);
	      while (!s.isEmpty() && s.peek() == popped[popIndex]){
	          s.pop();
	          popIndex++;
		}
	  }
	  return s.isEmpty();
    }

    public static void main(String[] args) {
	  int[] a ={1,2,3,4,5};
	  int[] b = {4,5,3,2,1};
	  Offer_31 test = new Offer_31();
	  System.out.println(test.validateStackSequences(a,b));
    }
}
