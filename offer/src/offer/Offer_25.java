package offer;

import offer.util.ListNode;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 *
 * 示例1：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * 限制：
 *
 * 0 <= 链表长度 <= 1000
 *
 * 注意：本题与主站 21 题相同：https://leetcode-cn.com/problems/merge-two-sorted-lists/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class Offer_25 {

    /**
     * 亮点：直接创建1个空的节点作为头节点，不用在各种条件下处理头节点的逻辑
     * */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
	  while (l1 != null &&  l2 != null) {
		if (l1.val < l2.val) {
		    cur.next = l1;
		    l1 = l1.next;
		} else {
		    cur.next = l2;
		    l2 = l2.next;
		}
		cur = cur.next;
	  }
	  cur.next = l1 == null ? l2 : l1;
	  return head.next;
    }

}
