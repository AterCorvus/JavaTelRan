package ItearatorVsGetApp;

import java.util.Collection;
import java.util.LinkedList;

public class application {
	

	private static final int NUM_NUM = 100000;

	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList();
		for (int i = 0; i < NUM_NUM; i++)
			ll.add(1);
		
		int size = ll.size();
		long t1 = System.currentTimeMillis();
		for (int i = 0; i < size; i++) 
			ll.get(i);
		
		long t2 = System.currentTimeMillis();
		System.out.println("Usual for: " + (t2 - t1));
		
		int a;
		t1 = System.currentTimeMillis();
		for (Integer i : ll)
			a = 0;
		t2 = System.currentTimeMillis();
		System.out.println("For each: " + (t2 - t1));
		
			
	}
	
}
