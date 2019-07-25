package application;

public class SomeThread implements Runnable {

	@Override
	public void run() {
		System.out.println("Some thread start");
		try {
			Thread.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			System.out.println("Catch visited");
		}
		System.out.println("Some thread finish");
	}

}
