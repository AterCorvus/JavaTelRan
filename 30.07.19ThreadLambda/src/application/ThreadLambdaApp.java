package application;

public class ThreadLambdaApp {
	
	public static void main(String[] args) {
		new Thread(()-> {
			try {
				Thread.sleep(2000);
			} catch (Exception e) {}
			System.out.println("thread");
		}).start();
		
		System.out.println("main");
	}
	
}
