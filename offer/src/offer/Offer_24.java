package offer;

import offer.util.ListNode;

public class Offer_24 {
    public ListNode reverseList(ListNode head) {
	  if (head == null) { return head;
	  }
	  ListNode pre,cur,next;
	  pre = null;
	  cur = head;
	  while (cur != null){
	      next = cur.next;
		cur.next = pre;
		pre = cur;
	       cur = next;
	  }
	  return pre;
    }

}
