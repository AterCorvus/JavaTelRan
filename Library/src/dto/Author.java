package dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

import enumerations.AuthorLastName;
import enumerations.AuthorName;
import randomlib.RandomLib;

public class Author implements Comparable<Author> {

	private String firstName;
	private String lastName;

	public Author(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	@Override
	public int compareTo(Author a) {
		int result;
		result = lastName.compareTo(a.lastName);

		if (result == 0)
			return firstName.compareTo(a.firstName);

		return result;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public static Author random() {
		String aFName = RandomLib.randomOfArray(AuthorName.values()).toString();
		String aLName = RandomLib.randomOfArray(AuthorLastName.values()).toString();
		return new Author(aFName, aLName);
	}
}
