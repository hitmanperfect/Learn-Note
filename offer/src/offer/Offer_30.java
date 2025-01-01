package offer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 *
 *  
 *
 * 示例:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 *  
 *
 * 提示：
 *
 * 各函数的调用总次数不超过 20000 次
 *
 * */
public class Offer_30 {

    class MinStack {
        Stack<Integer> main = new Stack<>();
        Stack<Integer> min = new Stack<>();
	  /** initialize your data structure here. */
	  public MinStack() {

	  }

	  public void push(int x) {
		main.push(x);
		if (min.empty() || x<=min.peek()) {
		    min.push(x);
		}
	  }

	  public void pop() {
		int x = main.pop();
		if (!min.empty() && x==min.peek()) {
		    min.pop();
		}
	  }

	  public int top() {
		return main.peek();
	  }

	  public int min() {
		return min.peek();
	  }
    }
}
