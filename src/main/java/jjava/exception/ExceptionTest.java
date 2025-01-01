package jjava.exception;

import java.util.concurrent.TimeUnit;

/**
 * 当进程存在多个线程时，若1个线程崩溃，不会引起应用崩溃
 * 处理逻辑在 {@link ThreadGroup#uncaughtException(Thread, Throwable)}  }。中
 * 而 {@link Thread#defaultUncaughtExceptionHandler} 为空，走了默认的打印逻辑。
 *
 * 只要一有异常，如NPE，就会调用当前线程的 {@link Thread#dispatchUncaughtException(Throwable)} 方法
 * 这个是在native 层调用，无法追溯调用栈
 */
public class ExceptionTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
		@Override
		public void run() {
		    Object o= null;
		    System.out.println(o.toString());
		}}).start();

	  while (true) {
		System.out.println(System.currentTimeMillis());
		try {
		    TimeUnit.SECONDS.sleep(2);
		} catch (Exception e) {
		    e.printStackTrace();;
		}
	  }
    }
}
