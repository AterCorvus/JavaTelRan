package response;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

import dto.Person;

public class ObjectEchoResponse implements Protocol {

	@Override
	public Object getResponse(Object request) {
		ArrayList<String> als = (ArrayList<String>) ((ArrayList<Person>)request).stream()
													.map((x)-> x.getName() +" : "+x.getAge())
													.collect(Collectors.toList());
		return als;
	}
}
