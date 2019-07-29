package application;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Kolkhoz implements Runnable {

	public static int zakroma;
	
	public static Lock lock = new ReentrantLock();
	
	@Override
	public void run() {
		
		lock.lock();
		try {
			for (int i = 0; i < 1000000; i++)zakroma++;
		}
		finally {
			lock.unlock();
		}
		
	}

}
