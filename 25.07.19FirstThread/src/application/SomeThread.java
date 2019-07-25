package application;

public class SomeThread extends Thread{

	@Override
	public void run() {
		System.out.println("Some thread start");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		
		System.out.println("Some thread finish");
		
	}
	
}
