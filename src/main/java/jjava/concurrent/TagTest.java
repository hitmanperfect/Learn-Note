package jjava.concurrent;

/**
 * 标签：
 * 	break tag ： 	停止该次循环，继续到下一行指令
 * 	continue tag：	继续下次循环，保留 循环参数 i,j 的值。
 *
 */
public class TagTest {
    public static void main(String[] args) {
//	  int i = 10,j=5;
	  System.out.println("start ");
	  out1:
	  for (int i = 0; i < 3; i++) {
		if (i == 1) {
		    continue out1;
		}
		System.out.println("i = " + i + " before");
		inner:
		for (int j = 0; j < 3; j++) {
		    if (j == 1) {
			  break inner;
		    }
		    System.out.println("j = " + j);
		}
		System.out.println("i = " + i + " after");
	  }
	  System.out.println("end");
    }
}
