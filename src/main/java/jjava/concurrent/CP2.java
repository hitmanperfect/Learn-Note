package jjava.concurrent;

import data_structure.BlockQueue;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 */
public class CP2 {
    static AtomicInteger integer = new AtomicInteger();
    static BlockQueue<Integer> queue = new BlockQueue(8);
    static long start = System.currentTimeMillis() / 1000;

    public static void main(String[] args) {


	  int consumerCount = 3;
	  int producerCount = 1;
	  for (int i = 0; i < consumerCount; i++) {
		new Thread(new C("consumer" + i)).start();
	  }
	  for (int i = 0; i < producerCount; i++) {
		new Thread(new P("producer" + i)).start();
	  }
    }

    static class C implements Runnable {
	  public C(String name) {
		this.name = name;
	  }

	  String name;

	  @Override
	  public void run() {
		while (true) {
		    try {
			  Integer i = queue.get();
			  long time = System.currentTimeMillis() / 1000;
			  if (i != null) {
				System.out.println((time - start) + "S : " + name + " consume :  " + i);
			  }

			  TimeUnit.SECONDS.sleep(1);
		    } catch (Exception e) {
			  e.printStackTrace();
		    }

		}
	  }
    }

    static class P implements Runnable {
	  public P(String name) {
		this.name = name;
	  }

	  String name;

	  @Override
	  public void run() {
		while (true) {
		    try {
			  int i = integer.getAndIncrement();
			  queue.put(i);
			  long time = System.currentTimeMillis() / 1000;
			  System.out.println((time - start) + "S : " + name + " add :  " + i);
			  TimeUnit.SECONDS.sleep(1);
		    } catch (Exception e) {
			  e.printStackTrace();
		    }

		}
	  }
    }
}
