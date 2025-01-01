package jjava.concurrent;

import java.util.concurrent.*;

/**
 *
 */
public class MyTPE extends ThreadPoolExecutor {
    public MyTPE(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
	  super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public MyTPE(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory) {
	  super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory);
    }

    public MyTPE(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, RejectedExecutionHandler handler) {
	  super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, handler);
    }

    public MyTPE(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
	  super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
	  super.beforeExecute(t, r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
	  System.out.println(" *********   afterExecute  before  ");
//	  System.out.println(r);
        t.printStackTrace();
	  super.afterExecute(r, t);
	  try {
		TimeUnit.SECONDS.sleep(3);
	  } catch (Exception e) {
	      e.printStackTrace();
	  }
	  System.out.println(" *********   afterExecute after   ");
    }
}
