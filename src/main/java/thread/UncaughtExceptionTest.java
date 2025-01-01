package thread;

import java.util.concurrent.TimeUnit;

public class UncaughtExceptionTest {
    public static void main(String[] args) {
	  System.out.println(Thread.currentThread().getName());
	  Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
		@Override
		public void uncaughtException(Thread t, Throwable e) {
		    System.out.println();
		    int i = 0;
		    try {
			  System.out.println(Thread.currentThread().getName() + " : " + i++);
//			  while (true) {
//				TimeUnit.SECONDS.sleep(1);
//				System.out.println(Thread.currentThread().getName() + i++);
//			  }
		    } catch (Exception e1) {
		        e1.printStackTrace();
		    }
		    throw new RuntimeException(" exception in uncaughtException");
		}
	  });
	  new Thread(new ThreadGroup("test"), new Runnable() {
		@Override
		public void run() {
//		    throw new RuntimeException("dsdsf");
		}
	  },"test_a").start();
//	  new Thread("test_a"){
//		@Override
//		public void run() {
//		    throw new RuntimeException("dsdsf");
//		}
//	  }.start();
//	  try {
//		TimeUnit.SECONDS.sleep(3);
//	  } catch (Exception e) {
//	      e.printStackTrace();
//	  }
	  throw new RuntimeException("dsdsf");

    }
}
