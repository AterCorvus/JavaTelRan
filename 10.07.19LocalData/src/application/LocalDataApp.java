package application;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class LocalDataApp {
	public static void main(String[] args) {
		LocalDate now = LocalDate.now();
		System.out.println(now);
		LocalDate birthday = LocalDate.of(1994, 07, 21);
		System.out.println(birthday);
		
		DateTimeFormatter atf = DateTimeFormatter.ofPattern("dd MMMM yyyy G, EEEE");
		System.out.println(now.format(atf));
		Period p = Period.between(birthday,  now);
		System.out.println(p);
	}
}
