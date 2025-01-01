package algoriphem;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class LRU_T {
    class Node{
	  int key , value;
	  Node pre,next;
	  public Node(int key,int value){
		this.key=key;
		this.value=value;
	  }
    }

    class DoubleList {
	  Node head, tail;

	  public DoubleList() {
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.pre = head;
	  }

	  void addFirst(Node n) {
		head.next.pre = n;
		n.next = head.next;
		head.next = n;
		n.pre = head;
	  }

	  void remove(Node n) {
		n.next.pre = n.pre;
		n.pre.next = n.next;
	  }

	  Node removeLast() {
		Node res = tail.pre;
		remove(res);
		return res;
	  }
    }
    Map<Integer,Node> map;
    DoubleList cache;
    int capacity;
    public LRU_T(int capacity) {
	  map=new HashMap<>();
	  cache= new DoubleList();
	  this.capacity=capacity;
    }

    public int get(int key) {
	  if(!map.containsKey(key))
		return -1;
	  Node n = map.get(key);
	  cache.remove(n);
	  cache.addFirst(n);
	  return n.value;
    }

    public void put(int key, int value) {
	  Node n = new Node(key,value);
	  if(map.containsKey(key)){
		cache.remove(map.get(key));
	  }else if(map.size()==capacity){
		Node last = cache.removeLast();
		map.remove(last.key);
	  }
	  cache.addFirst(n);
	  map.put(key,n);
    }
}
