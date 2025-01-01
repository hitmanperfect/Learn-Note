package jjava.bytecode;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.concurrent.TimeUnit;

public class RefTest {
    static long time = System.currentTimeMillis();
    public static void main(String[] args) {
	  RefTest t = new RefTest();
	  ReferenceQueue queue = new ReferenceQueue();
	  WeakReference ref = new WeakReference(t,queue);
	  t = null;
	  try {

		System.out.println("before gc" + (System.currentTimeMillis()- time));
		System.gc();
		TimeUnit.SECONDS.sleep(3);
		Reference r = queue.poll();
		System.out.println("after gc" + (System.currentTimeMillis() - time));
		System.out.println(r == ref);
		System.out.println(r.get());
	  } catch (Exception e) {
	      e.printStackTrace();
	  }

    }
    @Override
    protected void finalize() throws Throwable {
	  System.out.println("exec finalize" + (System.currentTimeMillis() - time));
    }
}
