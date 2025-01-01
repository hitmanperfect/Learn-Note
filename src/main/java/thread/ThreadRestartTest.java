package thread;

import util.Reflect;

import java.util.concurrent.TimeUnit;

public class ThreadRestartTest {
    public static void main(String[] args) {
	  Thread t = new Thread(new Runnable() {
		@Override
		public void run() {
		    System.out.println("llaa");
		}
	  });
	  t.start();

	  try {
		TimeUnit.SECONDS.sleep(3);
//		System.out.println("sys tgroup"+ System.getSecurityManager().getThreadGroup());
		Reflect.on(t).set("threadStatus",0).set("group",Thread.currentThread().getThreadGroup());
	  } catch (Exception e) {
	      e.printStackTrace();
	  }
	  System.out.println("reflect suc");
	  t.start();
    }
}
