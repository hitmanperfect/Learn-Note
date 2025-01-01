package thread;

import java.util.concurrent.TimeUnit;

/**
 * {@link Thread#yield()} static 方法，
 * 只是让出当前时间片，让其他线程执行，但 不能保证其他线程执行完后，自己才执行


 * {@link Thread#join(),Thread#join(long)}  , 普通方法
 * 	在当前线程 调用其他线程的  join 方法，
 * 	传参 = 0 时，无限期等待，必须等子线程执行完后，当前线程才会执行
 * 	传参 > 0 时，有限期等待，时间到后，当前线程便会执行，之后两个线程交替执行。
 */
public class YieldJoinTest {
    public static void main(String[] args) {
	  testYield();
//	  testJoin();
    }

    static long start;

    static void testYield() {
	  start = System.currentTimeMillis();
	  Thread t = new Thread(new Worker());
	  t.start();
	  //保证 t started
	  try {
		TimeUnit.MILLISECONDS.sleep(100);	//200ms 后 打印 main end
	  } catch (InterruptedException e) {
		e.printStackTrace();
	  }
	  Thread.yield();
	  System.out.println("main end : " + (System.currentTimeMillis() - start));
    }

    static void testJoin() {
	  start = System.currentTimeMillis();
	  Thread t = new Thread(new Worker());
	  t.start();
	  try {
//		t.join();			//无限期等待，在 sub 结束后，main 打印
		t.join(200);	//有限等待 ，200ms 过会，main 打印
	  } catch (InterruptedException e) {
		e.printStackTrace();
	  }
	  System.out.println("main end : " + (System.currentTimeMillis() - start));
    }

    static class Worker implements Runnable {
	  @Override
	  public void run() {
		int i = 0;
		int max = 1<<15;
		while (i < max) {
		    i++;
		    System.out.println(i);
		}

		System.out.println("sub end : " + (System.currentTimeMillis() - start));
	  }
    }
}
