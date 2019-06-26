package application;

import java.util.Random;

import model.MyHashSet;

public class MyHashSetApp {
	private static final int NUM_NUM = 12;
	static Random gen = new Random();
	
	public static void main(String[] args) {
		
		MyHashSet<Integer> hsi = new MyHashSet<>();
		for (int i = 0; i < NUM_NUM; i++) {
			hsi.add(gen.nextInt(1000));
		}
		
		hsi.display();
		System.out.println("**************************************");
		hsi.add(-666);
		hsi.add(-777);
		hsi.display();
		System.out.println(hsi.size());

		/*System.out.println(hsi.contains(50));
		System.out.println(hsi.remove(50));
		hsi.display();
		System.out.println(hsi.size());
		System.out.println(hsi.remove(500));
		System.out.println(hsi.size());*/
	}
}
