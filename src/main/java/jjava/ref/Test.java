package jjava.ref;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class Test {

    volatile static int a = 1;

    private static void test() {
	  ReferenceQueue queue = new ReferenceQueue();
	  new WeakReference(new Test(), queue);
	  new Thread(new Runnable() {
		@Override
		public void run() {
		    System.out.println("subThread ,= " + Thread.currentThread());
		    while (true) {
			  if (queue.poll() != null) {
				System.out.println("weak is enqued");
				break;
			  } else {
				System.gc();
				System.runFinalization();
				System.out.println(" sub thread wait");
			  }
		    }
		}
	  }).start();
//	  try {
//		TimeUnit.SECONDS.sleep(2);
//	  } catch (Exception e) {
//	      e.printStackTrace();
//	  }
	  while (true) {
		if (a == 2) {
		    System.out.println("finalize has execute");
		    break;
		} else {
		    System.gc();
		    System.runFinalization();
		    System.out.println(" main thread wait");
		}
	  }

    }

    public static void main(String[] args) {
	  System.out.println("start,thread = " + Thread.currentThread());
	  test();
    }

    @Override
    protected void finalize() throws Throwable {
	  System.out.println("run finalization,thread = " + Thread.currentThread());
	  a = 2;
    }
}
