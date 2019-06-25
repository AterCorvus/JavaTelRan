package application;

import dto.Person;
import dto.WrongDataException;

public class CastomExeptionApp {
	public static void main(String[] args) throws WrongDataException {
		Person p = new Person(null, 61, 176.3, true);
		System.out.println(p);
	}
}
