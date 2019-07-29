package application;

public class SomeThread implements Runnable{
	
	private static boolean wokenup = false;
	private static Object mutex = new Object();

	@Override
	public void run() {
		System.out.println("entered");
		
		synchronized (mutex) {		
			try {
				while(!wokenup) mutex.wait();
				//wokenup = !wokenup;
			} catch (InterruptedException e) {}
		}
		
		System.out.println("finished");
		
	}

	public static Object getMutex() {
		return mutex;
	}

	public static void setWokenup(boolean wokenup) {
		SomeThread.wokenup = wokenup;
	}
	

}
