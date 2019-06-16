package application;

import model.Chinese;

public class ChinieseApp {

	public static void main(String[] args) {
		Chinese[] china = new Chinese[1000];
		for (int i = 0; i < china.length; i++) {
			china[i] = new Chinese();
		}
		
		System.out.println(china[0].getName());
		System.out.println(china[999].getName());
		
		china[0].setName("Mag");
		
		System.out.println(china[0].getName());
		System.out.println(china[999].getName());
	}
}
