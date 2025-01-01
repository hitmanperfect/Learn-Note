package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 参考文档：
 * https://blog.csdn.net/hj7jay/article/details/53462553?utm_medium=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-1.no_search_link&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2%7Edefault%7EBlogCommendFromBaidu%7Edefault-1.no_search_link
 * https://blog.csdn.net/qq_38244610/article/details/106106276
 *
 * 中断相关方法：
 * {@link Thread#interrupt()}，给当前线程设置中断标记位，并不会中止当前线程执行。
 * {@link Thread#isInterrupted()} ，非静态方法，返回当前线程的终端标记，不清空标记位。
 * {@link Thread#interrupted()} ，静态方法，返回当前线程的中断标记，并清空标记位
 *
 * 中断含义与目的：
 *  * 一个线程有一个 中断 相关的标记位
 *  * 可通过 interrupt 手动设置标记位。并通过 interrupted 检测标记位，并进行相应处理，
 *
 * 哪些方法会触发中断检测 （检测 中断标记位）？
 * {@link Object#wait()} ,{@link Thread#sleep(long)} ,{@link Thread#join()} ,
 * {@link LockSupport#park()}
 * 以上这些方法均会 清除 当前线程的中断 标记位。
 *
 * 如何自定义中断检测？ 检测到中断后如何处理？ 二次抛出中断（重新设置中断标记位）？
 * 见demo {@link #interruptDemo()}
 *
 * */
public class InterruptTest {
    public static void main(String[] args) {
        testInterrupt();
//        Object o = new Object();
//	  Thread.currentThread().interrupt();
//	  synchronized (o) {
//		try {
//		    System.out.println("first: "+Thread.interrupted());
//		    System.out.println("second: "+Thread.interrupted());
////		    o.wait(3000);
////		    Thread.sleep(3000);
//		    test();
//		} catch (InterruptedException e) {
//		    e.printStackTrace();
//		}
//	  }
//
//	  System.out.println("haha");
    }

    /**
     * 手动设置线程中断后，可能会有一种通知机制，在可中断的方法内部，会一直检测中断标记位。
     *
     * 子线程在2ms 后开始执行，200ms 主线程设置 t 的中断位，在206ms后，子线程响应中断，打印崩溃栈后结束
     * */
    static void testInterrupt(){
        long start = System.currentTimeMillis();
	  System.out.println(" main start : " + start);
        Thread t = new Thread(new Runnable() {
		@Override
		public void run() {
		    try {
			  System.out.println("sub start : " + (System.currentTimeMillis()-start));
			  Thread.sleep(500);
		    } catch (InterruptedException e) {
			  System.out.println("sub exception : " + (System.currentTimeMillis()-start));
		        e.printStackTrace();;
		    }
		}
	  });
        t.start();
	  try {
		TimeUnit.MILLISECONDS.sleep(200);
	  } catch (InterruptedException e) {
	      e.printStackTrace();
	  }

	  t.interrupt();
    }

    static void interruptDemo() throws InterruptedException{
	  while (Thread.currentThread().interrupted()) {
		throw new RuntimeException("curThread is interrupted");
	  }
    }
}
