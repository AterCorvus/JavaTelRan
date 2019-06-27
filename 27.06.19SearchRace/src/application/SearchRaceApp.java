package application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class SearchRaceApp {
	private static final int NUM_NUM = 1000000;
	private static final int NUM_ITER = 100;

	static Random gen = new Random();
	
	public static void main(String[] args) {
		ArrayList<Integer> ali = new ArrayList<>();
		HashSet<Integer> hsi = new HashSet<>();
		
		for (int i = 0; i < NUM_NUM; i++) {
			ali.add(gen.nextInt(1000));
			hsi.add(gen.nextInt(1000));
		}
		
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < NUM_ITER*1000; i++) {
			ali.contains(gen.nextInt(1000));
		}
		long t2 = System.currentTimeMillis();
		System.out.println("ArrayList: " + (t2 - t1));
		
		t1 = System.currentTimeMillis();
		for (int i = 0; i < NUM_ITER*1000; i++) {
			hsi.contains(gen.nextInt(1000));
		}
		t2 = System.currentTimeMillis();
		System.out.println("Hash set: " + (t2 - t1));
	}
}
