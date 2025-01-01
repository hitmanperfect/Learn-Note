package jjava.lock;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
    public static void main(String[] args) {
	  testInterrupted();
    }

    static void testReentrantLock() {
        Lock lock = new ReentrantLock();
        lock.unlock();
        lock.lock();
	  System.out.println("lalal");
    }

    static void testInterrupted(){
        Lock lock = new ReentrantLock();
	  Condition condition = lock.newCondition();
	  Thread thread = Thread.currentThread();
	  long start = System.currentTimeMillis();
	  System.out.println(" start : 0");
	  new Thread(new Runnable() {
		@Override
		public void run() {
		    try {
		        TimeUnit.SECONDS.sleep(1);
			  System.out.println(" interrupt : " + (System.currentTimeMillis()-start));
			  thread.interrupt();

		    } catch (Exception e) {
			  e.printStackTrace();
		    }

		}
	  }).start();
	  lock.lock();
	  try {
		condition.await(3, TimeUnit.SECONDS);
	  } catch (Exception e) {
	      e.addSuppressed(new Exception());
		System.out.println(e);
//	      e.printStackTrace();
	  }finally {
	      lock.unlock();
	  }
	  System.out.println(" main end : " + (System.currentTimeMillis()-start));
    }
}
