package dao;

public class Address {
	String city;
	String street;

	public String getCity() {
		return city;
	}

	public String getStreet() {
		return street;
	}

	public Address(String city, String street) {
		super();
		this.city = city;
		this.street = street;
	}

	public Address() {
	}

	@Override
	public String toString() {
		return "Address [city=" + city + ", street=" + street + "]";
	}
}
