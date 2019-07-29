package application;

public class ReentatrantLockApp {

	private static int NUM_THREADS = 10;

	public static void main(String[] args) throws InterruptedException {
		Thread[] threads = new Thread[NUM_THREADS];
		for (int i = 0; i < threads.length; i++) threads[i] = new Thread(new Kolkhoz());
		for (int i = 0; i < threads.length; i++) threads[i].start();
		for (int i = 0; i < threads.length; i++) threads[i].join();
		
		System.out.println(Kolkhoz.zakroma);
	}
}
