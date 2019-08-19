package application.controller;

import java.util.Base64;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dto.Person;

@RestController
@RequestMapping("/greet")
public class GreetingsController {

	@GetMapping("/sasha")
	public String sasha() {
		return "Go to hell!";
	}
	
	@GetMapping("/masha")
	public String masha() {
		return "Glad to see you!";
	}
	
	@PostMapping("/goodMorning")
	public String goodMorning(@RequestBody Person person) {
		return "Good morning, "+person.getFirstName()+person.getLastName();
	}
	
	@GetMapping("/fullname")
	public String fullname (
			@RequestParam("fname") String firstName, 
			@RequestParam("lname") String lastName) {
		return firstName + " " + lastName;
	}
	
	@GetMapping("/auth")
	public String getAuth(@RequestHeader("Authorization") String auth) {
		return new String(Base64.getDecoder()
				.decode(auth.substring(auth.indexOf(" ") +1)));
		
	}
	
	@GetMapping("/name/{id}")
	public String getName(@PathVariable("id") int iid) {
		String[] names = {"Sasha", "Masha", "Dasha"};
		return iid >= 0 && iid < 3 ? names[iid] : "wrong id";
	}
}