package application;

public class WaitNotify1App {
	
	public static void main(String[] args) throws InterruptedException {
		
		SomeThread someThread1 = new SomeThread();
		SomeThread someThread2 = new SomeThread();
		Thread thread1 = new Thread(someThread1);
		Thread thread2 = new Thread(someThread2);
		thread1.start();
		thread2.start();
		
		//Thread.sleep(1000);
		
		Object mutex = SomeThread.getMutex();
		
		synchronized (mutex) {
			SomeThread.setWokenup(true);
			mutex.notifyAll();
		}
		
		System.out.println("main finished");
	}

}
