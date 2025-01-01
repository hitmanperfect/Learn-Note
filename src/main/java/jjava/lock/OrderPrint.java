package jjava.lock;

import dex.A;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OrderPrint {
    public static void main(String[] args) {
	String[] args1 = {"A","B","C"};
//	args1 = new String[]{"A"};
	orderPrinter(args1);
    }


    static void orderPrinter(String[] args){
        int ct =args.length;
        Lock lock = new ReentrantLock();
        Condition[] conditions = new Condition[ct];
	  for (int i = 0;i<ct;i++) {
	      conditions[i] = lock.newCondition();
	  }
        AtomicInteger curTag = new AtomicInteger(0);
	  for (int i = 0;i<ct;i++) {
	      int nextTag;
	      Condition notify;
		if (i == ct-1) {
		    nextTag = 0;
		    notify = conditions[0];
		}else{
		    nextTag = i+1;
		    notify = conditions[i+1];
		}
	      new Thread(new OrderPrinter(curTag,i,nextTag,args[i],lock,conditions[i],notify)).start();
	  }
    }
    static class OrderPrinter implements  Runnable{
        AtomicInteger curTag;
        int runTag;
        int nextTag;
        Lock lock;
        Condition wait ;
        Condition notify ;
        String msg;

        public OrderPrinter(AtomicInteger curTag,int runTag, int nextTag,String msg, Lock lock,Condition wait, Condition notify){
            this.curTag = curTag;
            this.runTag = runTag;
            this.nextTag = nextTag;
            this.msg = msg;
            this.lock = lock;
            this.wait = wait;
            this.notify = notify;
	  }

	  @Override
	  public void run() {

            while (true){
                lock.lock();
		    if (curTag.get() == runTag) {
			  System.out.println("tid" + Thread.currentThread().getId() + " : "+ msg);
			  curTag.set(nextTag);
			  notify.signal();
			  try {
				TimeUnit.SECONDS.sleep(1);
			  }catch (InterruptedException e){

			  }

		    }else{
		        try {
		            wait.await();
			  }catch (InterruptedException e){

			  }
		    }
                lock.unlock();
		}
	  }
    }
}
