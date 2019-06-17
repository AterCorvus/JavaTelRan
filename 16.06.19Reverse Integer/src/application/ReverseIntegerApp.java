package application;

public class ReverseIntegerApp {
	public static void main(String[] args) {
		System.out.println(reverse(123));
	}
	
	public static int reverse(int num) {
		int result = 0;
		while(num != 0){
			result = result*10 + num%10;
			num = num/10;
		}
		return result;
	}
}
