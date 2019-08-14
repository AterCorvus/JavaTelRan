package applications;
import java.io.File;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dto.Address;
import dto.Person;

public class CreatePersonsTestAppl {

	public static void main(String[] args) throws JsonMappingException, IOException {
		Person[] persons={
				new Person(123, new Address("Lod", "Sokolov"), "Vasya"),
				new Person(124, new Address("Netanya", "Plaut"),"Moshe")
		};
		ObjectMapper mapper=new ObjectMapper();
		File file=new File("persons.data");
		file.createNewFile();
		mapper.writeValue(file, persons);
	}

}
