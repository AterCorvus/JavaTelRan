package application;

import java.io.IOException;
import java.time.LocalDate;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import dto.Address;
import dto.Child;
import dto.Employee;
import dto.Person;

public class PersonsJsonInheritanceTestAppl {

	public static void main(String[] args) throws Exception {
	
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.registerModule(new JavaTimeModule());
		
		Child child = new Child(123, new Address("Lod", "Vaizman"), "Vasya", LocalDate.of(2014, 5, 12), "Vasilok");
		Employee employee = new Employee(124, new Address("Rehovot", "Plaut"), "Moshe", LocalDate.of(1970, 1, 10), "Motorola", 15000);
		
		Person[] persons = { child, employee };
		String jsonPerson = mapper.writeValueAsString(persons);
		System.out.println(jsonPerson);
		
		Person restoredPersons[] = mapper.readValue(jsonPerson, Person[].class);
		for (Person person : restoredPersons) System.out.println(person);
		
	}
}
