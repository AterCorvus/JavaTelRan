package application;

public class StringEqualApp {
	
	public static void main(String[] args) {
		
		String str1 = "Sasha";
		String str2 = "Sasha";
		String str3 = "Sa" + "sha";
		String str4 = "Sa";
		String str5 = "sha";
		String str6 = str4 + str5;
		
		System.out.println(str1.equals(str6));
		System.out.println(str1 == str6);
	}
	
}
