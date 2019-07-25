package application;

public class FirstThreadApp {

	public static void main(String[] args) {
		Thread someThread = new SomeThread();
		Thread anotherThread = new Thread(new AnotherThread());
		
		someThread.start();
		anotherThread.start();
		
		System.out.println("main finished");
	}

}
