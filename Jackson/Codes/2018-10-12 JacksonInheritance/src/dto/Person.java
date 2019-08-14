package dto;


import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor

@JsonTypeInfo(use = Id.CLASS)

public class Person {
	
	@Getter private int id;
	@Getter private Address address;
	@Getter private String name;
	
	@JsonFormat(pattern = "yyyy_MMM_dd") 
	@Getter private LocalDate birthdate;
}
