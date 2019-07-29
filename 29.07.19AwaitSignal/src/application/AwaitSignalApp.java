package application;

public class AwaitSignalApp {

		public static void main(String[] args) throws InterruptedException {
			Thread thread = new Thread(new SomeThread());
			thread.start();
			
			Thread.sleep(1000);
			
			SomeThread.lock.lock();
			try {
				SomeThread.flag = false;
				SomeThread.condition.signal();
			} finally {
				SomeThread.lock.unlock();
			}
			System.out.println("main finished");
		}
	
}
