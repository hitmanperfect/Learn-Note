package jjava.concurrent;

import java.util.concurrent.*;

/**
 *
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
	  try {
//		throw new Error("sss");
		throw new RuntimeException("ss");
	  }finally {
		System.out.println("j");
	  }
    }
    static void testCachedPool() {
//
	  ThreadPoolExecutor pool = new MyTPE(3, 3,
		    0L, TimeUnit.MILLISECONDS,
		    new LinkedBlockingQueue<Runnable>(),
		    new MyThreadFactory());
//	  ExecutorService pool = Executors.newFixedThreadPool(5,new MyThreadFactory());
//	  ExecutorService pool = Executors.newFixedThreadPool(5);
	  for (int i = 0; i < 1; i++) {
		pool.execute(() -> {
		    System.out.println("current thread name" + Thread.currentThread().getName());
		    Object object = null;
		    System.out.print("result## "+object.toString());
		});
//		Future futureTask = threadPool.submit(new Callable<Object>() {
//		    @Override
//		    public Object call() throws Exception {
//			  Object object = null;
//			  System.out.print("result## "+object.toString());
//			  return null;
//		    }
//		});
//		try {
//		    futureTask.get();
//		} catch (Exception e) {
//		    e.printStackTrace();
//		}

	  }

//	  try {
//		TimeUnit.SECONDS.sleep(1);
//	  } catch (InterruptedException e) {
//	      e.printStackTrace();
//	  }
//	  System.out.println(threadPool.);

    }
}
