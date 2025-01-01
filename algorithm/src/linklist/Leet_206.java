package linklist;

import util.ListNode;

/**
 * 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 
 *
 * 示例 1：
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 *
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 *
 * 输入：head = []
 * 输出：[]
 * 
 *
 * 提示：
 *
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 *
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * */
public class Leet_206 {
    /**
     * 1、只需要处理 cur 和 pre 即可
     * */
    public ListNode reverse(ListNode node) {
	  if (node == null) {
	      return null;
	  }
	  ListNode pre=null,cur=node,next ;
	  while (cur != null) {
	      next = cur.next;
	      cur.next = pre;
	      pre = cur;
	      cur = next;
	  }
	  return pre;
    }
}
