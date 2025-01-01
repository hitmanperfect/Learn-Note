package jjava.concurrent;

import java.util.concurrent.ThreadFactory;

/**
 *
 */
public class MyThreadFactory implements ThreadFactory {

    int count = 0;
    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r,"subThread : " + count++);
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
		@Override
		public void uncaughtException(Thread t, Throwable e) {
		    System.out.println("*********** crash happens in : " + t.getName());
		    e.printStackTrace();
		}
	  });
	  return t;
    }
}
