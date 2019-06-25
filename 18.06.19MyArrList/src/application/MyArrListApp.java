package application;

import java.util.Iterator;
import java.util.Random;

import model.MyArrayList;
import model.MyArrayListOutOfBounds;

public class MyArrListApp {
	
	private static final int NUM_NUM = 10;
	static Random gen = new Random(12345);
	
	public static void main(String[] args) {
		MyArrayList<Integer> mali = new MyArrayList<>();
		/*for (int i = 0; i < NUM_NUM; i++)
			mali.add(gen.nextInt(10));
		
		System.out.println(mali.toString());
		System.out.println(mali.get(5));
		//System.out.println(mali.set(666, 8));
		System.out.println(mali);
		//mali.add(888, 10);
		System.out.println(mali);
		System.out.println(mali.indexOf(888));
		System.out.println(mali.contains(6666));
		/*System.out.println(mali.array.length);
		mali.trim();
		System.out.println(mali.array.length);
		mali.shuffle();
		System.out.println(mali);
		mali.removeRange(1,3);
		System.out.println(mali);
		System.out.println(mali.size());*/
		
		mali.add(1);
		mali.add(2);
		mali.add(3);
		
		/*Iterator<Integer> it = mali.iterator();
		int res = 0;
			try {
				for (int i = 0; i < 4; i++) {
					res = it.next();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
		}
		System.out.println("finifhed");*/
		
		try {
			mali.add(333, 5);
		} catch (MyArrayListOutOfBounds e) {
			System.out.println(e.getMessage());
			System.out.println("index: " + e.getIndex());
			System.out.println("size: " + e.getSize());
		}
		System.out.println(mali);
	}
	
}
