package applications;
import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import dto.Person;

public class RestorePersonsTestAppl {

	public static void main(String[] args) throws Exception{
		ObjectMapper mapper=new ObjectMapper();
		File file=new File("persons.data");
		Person[] persons=mapper.readValue(file, Person[].class);
		for(Person person:persons)
			System.out.println(person);

	}

}
