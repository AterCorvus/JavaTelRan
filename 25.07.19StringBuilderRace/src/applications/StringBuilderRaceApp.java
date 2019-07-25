package applications;

import java.util.ArrayList;

public class StringBuilderRaceApp {
	
	private static final int NUM_THREADS = 10;

	public static void main(String[] args) throws InterruptedException {
		ArrayList<Thread> alThrd = new ArrayList<>();
		for (int i = 0; i < NUM_THREADS; i++)
			alThrd.add(new Thread(new SomeThread()));
		
		for(Thread thread : alThrd)
			thread.start();
		
		for(Thread thread : alThrd)
			thread.join();
		
		System.out.println(SomeThread.sb.length());
	}
	
}
