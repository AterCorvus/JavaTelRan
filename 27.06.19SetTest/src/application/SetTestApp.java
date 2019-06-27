package application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class SetTestApp {

	private static final int NUM_NUM = 10;
	static Random gen = new Random();
	
	public static void main(String[] args) {
		ArrayList<Integer> ali = new ArrayList<>(); 
		
		for (int i = 0; i < NUM_NUM; i++)
			ali.add(gen.nextInt(10));
		
		System.out.println(ali.toString());
		HashSet<Integer> hsi = new HashSet<Integer>(ali);
		System.out.println(hsi.toString());
		int res = countTwins(ali);
		System.out.println(res);
	}
	
	static public int countTwins(ArrayList<Integer> ali) {
		int twins = 0;
		HashSet<Integer> hsi = new HashSet<Integer>(ali);
		for(Integer el : hsi) {
			if(hsi.contains(el++)){
				twins += countTwins(ali, el);
			}	
		}
		return twins;
	}
	
	static public int countTwins(ArrayList<Integer> ali, Integer element) {
		int size = ali.size();
		int dupl = 0;
		boolean haveTwin = false;
		for (int i = 0; i < size; i++){
			if(element == ali.get(i)) { 
				dupl++;
				ali.remove(i);
				size--;
			}
			
			if(element == ali.get(i) + 1)
				haveTwin = true;
		}
		
		if(haveTwin == true)
			return dupl;
		
		return 0;
	}
}
