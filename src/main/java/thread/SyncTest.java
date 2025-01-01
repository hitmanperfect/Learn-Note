package thread;

import java.util.concurrent.TimeUnit;

/**
 *
 */
public class SyncTest {
    static Object o = new Object();
    static Object o1 = new Object();
    public static void main(String[] args) {

	  new Thread(new Runnable() {
		@Override
		public void run() {
		    synchronized (o) {
			  try {
				TimeUnit.SECONDS.sleep(1);
			  } catch (InterruptedException e) {
				e.printStackTrace();
			  }
			  o1.notify();
		    }
		}
	  }).start();
	  synchronized (o){
		try {
		    o1.wait();
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}

	  }

	  System.out.println("haha");
    }
}
