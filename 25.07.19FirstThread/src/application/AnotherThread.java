package application;

public class AnotherThread implements Runnable{

	@Override
	public void run() {
		System.out.println("Another thread start");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		
		System.out.println("Another thread finish");
	}

}
