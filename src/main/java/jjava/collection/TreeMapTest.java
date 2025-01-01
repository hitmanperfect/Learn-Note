package jjava.collection;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeMapTest {
    public static void main(String[] args) {
	  TreeSet<String> set = new TreeSet<String>(new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
		    return o1.compareTo(o2);
		}
	  });
	  set.add("a");
	  set.add("b");
	  System.out.println(set.first());
	  System.out.println(set.last());
	  System.out.println("----------");
	  set.add("c");
	  System.out.println(set.first());
	  System.out.println(set.last());
    }
}
