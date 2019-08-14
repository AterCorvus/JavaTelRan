package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import dao.Address;
import dao.Person;


public class PersonsJsonTestAppl {

	public static void main(String[] args) throws Exception {
		
		ArrayList<Person> alpIni = new ArrayList<>();
		ArrayList<Person> alpRes = new ArrayList<>();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		
		Person p1 = new Person(124, new Address("Rehovot", "Plaut"), "Moshe", LocalDate.of(1970, 1, 10));
		Person p2 = new Person(123, new Address("Lod", "Vaizman"), "Vasya", LocalDate.of(2014, 5, 12));
		alpIni.add(p1);
		alpIni.add(p2);
		
		//ObjectWriter ow = mapper.writerFor(new TypeReference<ArrayList<Person>>() {});
		ObjectWriter ow = mapper.writerFor(mapper.getTypeFactory().constructCollectionType(ArrayList.class, Person.class));
		String jsonPerson = ow.writeValueAsString(alpIni);
		System.out.println(jsonPerson);
		
		alpRes = mapper.readValue(jsonPerson, new TypeReference<ArrayList<Person>>() { });
		System.out.println(alpRes);	
		
		for (Person person : alpRes) {
			System.out.println(person);
		}
	}

}
