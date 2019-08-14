package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Person {
	
	@Getter private int id;
	@Getter private Address address;
	@Getter private String name;
}
