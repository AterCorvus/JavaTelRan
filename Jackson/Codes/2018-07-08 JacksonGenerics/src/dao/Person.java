package dao;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@JsonTypeInfo(use = Id.CLASS)
public class Person {
	int id;
	Address address;
	String name;
	LocalDate birthdate;

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public Person(int id, Address address, String name, LocalDate birthdate) {
		super();
		this.id = id;
		this.address = address;
		this.name = name;
		this.birthdate = birthdate;
	}

	public Person() {
	}

	public int getId() {
		return id;
	}

	public Address getAddress() {
		return address;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", address=" + address + ", name=" + name + ", birthdate=" + birthdate + "]";
	}

}
