package application;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SomeThread implements Runnable {

	public static Lock lock = new ReentrantLock();
	public static Condition condition = lock.newCondition();
	public static boolean flag = true;
	
	@Override
	public void run() {
		
		lock.lock();
		try {
			while (flag)
				try {
					condition.await();
				} catch (InterruptedException e) {
				} 
		} finally {
			lock.unlock();
		}
		
		System.out.println("SomeThread finished");

	}

}
