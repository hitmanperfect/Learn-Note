package jjava.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
//	  List<String> list = new ArrayList();
//	  list.add("1");
//	  list.add("2");
//	  for (int i = 0;i<list.size();i++) {
//		if ("2".equals(list.get(i))) {
//		    list.remove(list.get(i));
//		}
//	  }
//	  for (String item : list) {
//		if ("2".equals(item)) {
//		    list.remove(item);
//		}
//	  }

//	  Iterator<String> iterator = list.iterator();
//	  while (iterator.hasNext()) {
//		String item = iterator.next();
//		if ("2".equals(item)) {
//		    iterator.remove();
//		}
//	  }

//	  System.out.println(list);
	  List list  = new ArrayList<>();
	  int len = 5;
	  for (int i = 0;i<len;i++) {
		list.add(i);
	  }
	  Iterator iterator = list.iterator();
	  while (iterator.hasNext()) {
		iterator.next();
	      iterator.remove();
		System.out.println(list);
	  }
//	  for (int i = 0;i<len;i++) {
//		list.add(i);
//	  }
//	  System.out.println(list);
////	  list.iterator();
//	  int j= 0;
//	  System.out.println("list.size="+ list.size());
//	  try {
//		for (int i = 0; i < list.size(); i++) {
//		    System.out.println("i=" + i);
//		    if (i == 3) {
//			  list.remove((Integer)i);
//		    }
//		    System.out.println(list);
//		}
//	  } catch (Exception e) {
//	      e.printStackTrace();
//	  }

    }
}
