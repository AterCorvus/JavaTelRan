package application;

import dto.Country;

public class CreditorsApp {
	public static void main(String[] args) {
		try {
			Country israel = new Country(300);
			israel.printBiggetCreditor();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
