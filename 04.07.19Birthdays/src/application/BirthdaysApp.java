package application;

import dto.Office;

public class BirthdaysApp {
	private static final int ROOMS_NUMB = 100;

	public static void main(String[] args) {
		Office office = new Office(ROOMS_NUMB);
		System.out.println(office.countPairBirthdRooms());
	}
}
