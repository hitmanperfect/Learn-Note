package data_structure;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class BlockQueue<T> {
    Lock lock = new ReentrantLock();
    Condition notFull = lock.newCondition();
    Condition notEmpty = lock.newCondition();
    int count;
    int head;
    int tail;
    public BlockQueue(int size) {
	  this.elements = (T[])new Object[size];
    }

    T[] elements;

    public void put(T o) {
	  lock.lock();
	  try {
		while (count == elements.length) {
		    notFull.await();
		}
		elements[tail++] = o;
		if (++tail == elements.length) {
		    tail=0;
		}
		count++;
		notEmpty.signal();
	  }catch (InterruptedException e){
		e.printStackTrace();
	  }
	  finally {
		lock.unlock();
	  }
    }
    public T get() {
	  lock.lock();
	  T res = null;
	  try {
		while (count == 0) {
		    notEmpty.await();
		}
		res = elements[head++];
		if (++head == elements.length) {
		    head=0;
		}
		count--;
		notFull.signal();

	  }catch (InterruptedException e){
		e.printStackTrace();
	  }
	  finally {
		lock.unlock();
		return res;
	  }

    }
}
