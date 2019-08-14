package application;

import java.time.LocalDate;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import dto.Address;
import dto.Child;
import dto.Employee;
import dto.Person;

public class PersonsJsonXMLTestAppl {

	public static void main(String[] args) throws Exception {
		
		XmlMapper mapper = new XmlMapper();
		
		mapper.registerModule(new JavaTimeModule());
		
		Child child = new Child(123, new Address("Lod", "Vaizman"), "Vasya", LocalDate.of(2014, 5, 12), "Vasilok");
		Employee employee = new Employee(124, new Address("Rehovot", "Plaut"), "Moshe", LocalDate.of(1970, 1, 10), "Motorola", 15000);
		
		Person[] persons = { child, employee };
		String xmlPerson = mapper.writeValueAsString(persons);
		System.out.println(xmlPerson);
		
		Person restoredPersons[] = mapper.readValue(xmlPerson, Person[].class);
		for (Person person : restoredPersons) System.out.println(person);

	}
	

}
