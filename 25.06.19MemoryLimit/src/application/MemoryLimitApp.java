package application;

public class MemoryLimitApp {
	public static void main(String[] args) {
		int[] arr;
		
		int left = 0;
		int right = Integer.MAX_VALUE;
		
			try {
				arr = new int[right];
				System.out.println("Your computer good enough");
				return;
			} catch (Error e) {}
			
			int middle = 0;
			while(right - left > 1) {
				arr = null;
				middle = left + (right - left)/2;
				
				try {
					arr = new int[middle];
					left = middle;
				} catch (Error e) {
					right = middle;
				}
			}
			System.out.println(left);
	}

}
