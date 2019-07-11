package dto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

import enumerations.AuthorLastName;
import enumerations.AuthorName;
import enumerations.PublisherCountry;
import enumerations.PublisherName;
import randomlib.RandomLib;

public class Publisher implements Comparable<Publisher> {

	private String name;
	private String country;

	public Publisher(String name, String country) {
		super();
		this.name = name;
		this.country = country;
	}

	@Override
	public int compareTo(Publisher p) {
		int result;
		result = name.compareTo(p.name);
		if (result != 0)
			return result;

		return country.compareTo(p.country);
	}

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}
	
	public static Publisher random() {
		String name = RandomLib.randomOfArray(PublisherName.values()).toString();
		String country = RandomLib.randomOfArray(PublisherCountry.values()).toString();
		return new Publisher(name, country);
	}
}
