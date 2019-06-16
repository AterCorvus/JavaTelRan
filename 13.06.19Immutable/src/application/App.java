package application;

import model.ImPerson;

public class App {
	public static void main(String[] args) {
		ImPerson p = new ImPerson("Valera", 24);
		
		String sasha = "Sasha";
		String masha = sasha.substring(2);
		System.out.println(sasha);
		System.out.println(masha);
	}
}
