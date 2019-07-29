package application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class VolatileApp {
	
	public static void main(String[] args) throws IOException {
		Thread thread = new Thread(new SomeThread());
		thread.start();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		br.readLine();
		Container.flag = false;
		
		System.out.println("main finished");
	}
	
}
