package application;

public class First implements Runnable{

	@Override
	public void run() {
		System.out.println("First entered run");
		
		synchronized (MutexStorage.mutex1) {	
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		
			System.out.println("First woke up");
			
			synchronized (MutexStorage.mutex2) {
				System.out.println("First entered the inner block");
			}
		}
		
		System.out.println("First finished");
	}

}
