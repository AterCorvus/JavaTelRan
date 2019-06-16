package application;

public class SplitJoinApp {

	public static void main(String[] args) {
		String data = "Sasha\t   ;62\t    ; 176.5\t;true    ";
		String[] elements = data.trim().split(";");
		for (int i = 0; i < elements.length; i++) {
			elements[i] = elements[i].trim();
			System.out.println(elements[i]);
		}
		System.out.println(String.join(",", elements));
	}
	
}
