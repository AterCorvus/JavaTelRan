package application;

public class BitwiseOperatorApp {
	public static void main(String[] args) {
		/*int a = 33;
		
		System.out.println(~a);
		
		byte x = 5;
		byte y = 61;
		
		System.out.println((x ^ y) ^ y);*/
		
		String cipher = gamma("arabiansattackatyomkippur", "justdoit");
		System.out.println(cipher);
		String orig = gamma(cipher, "justdoit");
		System.out.println(orig);
	}
	
	public static String gamma(String orig, String key) {
		String res = "";
		for (int i = 0; i < orig.length(); i++) {
			res = res + (char)(orig.charAt(i) ^ key.charAt(i%key.length()));
		}
		return res;
		
	}
}
