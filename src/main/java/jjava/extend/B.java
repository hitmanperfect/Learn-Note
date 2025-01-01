package jjava.extend;

import java.util.concurrent.CountDownLatch;

public class B extends A{
    public static void main(String[] args) {
	  final CountDownLatch latch = new CountDownLatch(2);
	  for (int i = 0;i<2;i++) {
	      new Thread(new Runnable() {
		    @Override
		    public void run() {
			  System.out.println("sub thread start");
			  latch.countDown();

		    }
		}).start();
	  }
	  try {
		Thread.sleep(3000);
		latch.await();
		System.out.println("main thread end");
	  } catch (Throwable e) {
	      e.printStackTrace();
	  }


    }
}
