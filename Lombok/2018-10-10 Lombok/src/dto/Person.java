package dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	
	@Getter @Setter private String name;
	@Getter @Setter private int age;
	@Getter @Setter private double weight;
	@Getter @Setter private boolean married;
	
}
