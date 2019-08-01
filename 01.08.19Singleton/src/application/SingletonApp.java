package application;

public class SingletonApp {
	
	public static void main(String[] args) {
		SingletonPersonEnum.SASHA.setAge(40);
		System.out.println(SingletonPersonEnum.SASHA.getAge());
	}
	
}
