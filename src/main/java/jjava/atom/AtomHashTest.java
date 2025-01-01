package jjava.atom;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomHashTest {
    public static void main(String[] args) {
	  AtomicInteger atomic = new AtomicInteger(3);
	  System.out.println("atomic 3.hashcode : "+ atomic.hashCode());
	  Map<AtomicInteger,String> map = new HashMap<>();
	  map.put(atomic,"3");
	  atomic.set(4);
	  System.out.println("atomic 4.hashcode : "+ atomic.hashCode());
	  System.out.println(map.get(atomic));
    }
}
