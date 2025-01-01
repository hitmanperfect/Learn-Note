package linklist;

import util.ListNode;

public class HasRingList {
    public boolean hasCycle(ListNode head) {
	  ListNode slow,fast;
	  fast = slow = head;
	  while(fast != null && fast.next != null){
	      fast = fast.next.next;
	      slow = slow.next;

	      if(fast == slow) return true;
	  }
        return false;
    }
}

