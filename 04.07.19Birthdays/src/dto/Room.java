package dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class Room {
	private static final int DAYS_IN_YEAR = 360;
	private Random gen = new Random();
	private ArrayList<Person> room = new ArrayList<>();
	private boolean hasPairBirthdays = false;

	public Room(int personNumb) {
		super();
		if (personNumb < 0)
			throw new IllegalArgumentException("Persons in room can't be < 0");
			
		for (int i = 0; i < personNumb; i++) {
			room.add(new Person (gen.nextInt(DAYS_IN_YEAR)));
		}
	}
	
	public boolean hasPairBirthdays(){
		if (hasPairBirthdays)
			return true;
			
		HashSet<Integer> birthdays = new HashSet<>();
		for (Person person : room) {
			if (!birthdays.add(person.getBirthday())){
				hasPairBirthdays = true;
				return true;
			}
		}
		return false;
	}
}
