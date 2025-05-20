package offer;

import offer.util.ListNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 */
public class Offer_06 {

	static final int a ;
	static {
		a = 6;
	}
    public static void main(String[] args) {
//		a = 6;
	  new Offer_06().test();
    }
    // 用链表时间复杂度略高
    public int[] reversePrint(ListNode head) {
	  if (head == null) return new int[0];
	  LinkedList<Integer> queue = new LinkedList<>();
	  while (head != null) {
		queue.add(head.val);
		head = head.next;
	  }
	  int[] res = new int[queue.size()];
	  for (int i = 0;i<queue.size();i++) {
	      res[i] = queue.get(i); // 用链表时间复杂度略高
	  }
	  return res;
    }

    // 用栈要相对好一些
    public int[] reversePrint_1(ListNode head) {
	  if (head == null) return new int[0];
	  Stack<Integer> stack = new Stack<>();
	  while (head != null) {
		stack.push(head.val);
		head = head.next;
	  }
	  int[] res = new int[stack.size()];
	  int index = 0;
	  while (!stack.empty()){
	      res[index++] = stack.pop();
	  }
	  return res;
    }

    void test() {
        ListNode head = new ListNode(1);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(2);
        head.next = h2;
        h2.next = h3;
	  System.out.println(Arrays.toString(reversePrint(head)));
    }
}
