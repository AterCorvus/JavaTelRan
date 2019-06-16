package application;

public class MultipleConcApp {

	private static final int NUM_HELLOS = 10000;

	public static void main(String[] args) {
		String hello = "Hello";
		String result = "";
		
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < NUM_HELLOS; i++) {
			result = result + hello;
		}
		long t2 = System.currentTimeMillis();
		System.out.println("Concatination"+(t1-t2)+ " ms");
		
		t1 = System.currentTimeMillis();
		StringBuilder stringBuilder = new StringBuilder("");
		for (int i = 0; i < NUM_HELLOS; i++) {
			stringBuilder.append(hello);		
		}
		t2 = System.currentTimeMillis();
		System.out.println("Concatination"+(t1-t2)+ " ms");
	}
	
}
