package application;

import java.util.concurrent.atomic.AtomicInteger;

public class Kolkhoz implements Runnable {

	private static final int NUM_NUM_GRAINS = 100000;
	public static AtomicInteger motherlandZakroma = new AtomicInteger(0);
	
	@Override
	public void run() {
		
		for (int i = 0; i < NUM_NUM_GRAINS; i++) {
			motherlandZakroma.incrementAndGet();
		}
		
	}
}
