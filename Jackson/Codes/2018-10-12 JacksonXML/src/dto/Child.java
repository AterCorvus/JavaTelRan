package dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class Child extends Person {
	
	@Getter private String kindergarten;

	public Child(int id, Address address, String name, LocalDate birthdate, String kindergarten) {
		super(id, address, name, birthdate);
		this.kindergarten = kindergarten;
	}

	@Override
	public String toString() {
		return "Child [kindergarten=" + kindergarten + "] super: "+super.toString();
	}


}
