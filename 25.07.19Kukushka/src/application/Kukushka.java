package application;

public class Kukushka extends Thread{

	private int num = 0;
	private Thread prevKuk;
	
	public Kukushka(Thread kuk, int n){
		prevKuk = kuk;
		num = n;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(Long.MAX_VALUE);
		} catch (InterruptedException e) {
			System.out.println("Kuku" + num);
			if(this.prevKuk != null)
				this.prevKuk.interrupt();
		}
	}
	
}
