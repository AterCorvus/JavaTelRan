package application;

public class Second implements Runnable{

	@Override
	public void run() {
		System.out.println("Second entered run");
		
		synchronized (MutexStorage.mutex2) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {}
		
			System.out.println("Second woke up");
			
			synchronized (MutexStorage.mutex1) {
				System.out.println("Second inside the inner block");
			}
		
		}
		System.out.println("Second finished");
	}

}
