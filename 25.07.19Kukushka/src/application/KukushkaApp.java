package application;

import java.util.ArrayList;

public class KukushkaApp {
	private static final int NUM_THREADS = 10;

	public static void main(String[] args) {
		Thread kuk = null;
		for (int i = 0; i < NUM_THREADS; i++)
		{
			kuk = new Kukushka((Kukushka)kuk, i);
			kuk.start();
		}
		
		kuk.interrupt();
		
	}
}
