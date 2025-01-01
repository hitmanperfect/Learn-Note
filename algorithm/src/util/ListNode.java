package util;

public class ListNode {
    int val;
    public ListNode next;

    ListNode(int x) {
	  val = x;
	  next = null;
    }
    ListNode(int x,ListNode next) {
	  val = x;
	  this.next = next;
    }
}
