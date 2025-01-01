package jjava.concurrent;

import data_structure.BlockQueue;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class CP {
    static AtomicInteger integer = new AtomicInteger();
    static LinkedBlockingDeque<Integer> queue = new LinkedBlockingDeque<>(8);
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
		    Integer i = null;
		    try {
		        while (  i == null){
				i = queue.poll(1, TimeUnit.SECONDS);
			  }
			  long time = System.currentTimeMillis() / 1000;
			  System.out.println((time - start) + "S : " + name + " consume :  " + i);
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
			  while (  !queue.offer(i, 1, TimeUnit.SECONDS)){
			  }
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
