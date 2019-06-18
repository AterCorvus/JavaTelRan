package application;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchApp {
	private static final int NUM_NUM = 20;
	
	static Random gen = new Random();
	public static void main(String[] args) {
		
		int[] arr = new int[NUM_NUM];
		for (int i = 0; i < arr.length; i++) 
			arr[i] = gen.nextInt(20);
		
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.binarySearch(arr, 19));
		System.out.println(binarySearch(arr, 19));
	}
	
	public static int binarySearch(int[] arr, int value) {
		if (value < arr[0]) return -1;
		if (value > arr[arr.length - 1]) return -1-arr.length;
		
		if (value == arr[0]) return 0;
		if (value == arr[arr.length - 1]) return arr.length - 1;
		
		int left = 0;
		int right = arr.length - 1;
		
		while (right - left > 1) {
			int middle = (right+left)/2;
			if (arr[middle] == value) return middle;
			if (arr[middle] > value) right = middle;
			else left = middle;
		}
		return -1-right;
	}
}
