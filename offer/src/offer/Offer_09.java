package offer;

import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 * <p>
 * 1 <= values <= 10000
 * 最多会对appendTail、deleteHead 进行10000次调用
 */
public class Offer_09 {

    class CQueue {
	  Stack<Integer> s1 = new Stack();
	  Stack<Integer> s2 = new Stack();

	  public CQueue() {

	  }

	  public void appendTail(int value) {
		s1.push(value);
	  }

	  public int deleteHead() {
		if (s2.empty()) {
		    if (s1.empty()) {
			  return -1;
		    } else {
			  while (!s1.empty()) {
				s2.push(s1.pop());
			  }
			  return s2.pop();
		    }
		} else {
		    return s2.pop();
		}
	  }
    }
}
