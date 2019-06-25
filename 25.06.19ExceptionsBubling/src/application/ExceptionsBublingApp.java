package application;

public class ExceptionsBublingApp {
	public static void main(String[] args) {
		f1();
		System.out.println("main finished");
	}
	
	private static void f1() {
		f2();
		System.out.println("f1 fin");
	}
	
	private static void f2() {
		String str = "5321z";
		int i = 0;
		try{
			i = Integer.parseInt(str);
		}
		catch (NullPointerException e) {
			 i = 999999;
		}
		System.out.println("f2 fin with i = " + i);
	}
}
