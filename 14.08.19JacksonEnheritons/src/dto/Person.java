package dto;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Person {
	
	private String name;
	private LocalDate birthDate;
}
