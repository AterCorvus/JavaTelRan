package application;

import java.util.ArrayList;

public class ConcurentRaceApp {
	
	private static final int NUM_KOLHOZ = 100;

	public static void main(String[] args) throws InterruptedException {
		ArrayList<Thread> alk = new ArrayList<>();
		for(int i = 0; i < NUM_KOLHOZ; i++)
			alk.add(new Thread(new Kolkhoz()));
			
		for(Thread t : alk)
			t.start();
		
		for(Thread t : alk)
			t.join();
		
		System.out.println(Kolkhoz.motherlandZakroma);
	}
	
}
