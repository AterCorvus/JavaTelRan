package dto;

import java.util.ArrayList;
import java.util.Random;

import randomLib.RandomLib;

public class Country {
	private static final String[] NAMES = { "Ivan", "Moysha", "John", "Lana", "Sara", "Ura", "Gal",
			"Kayl", "Eric", "Vincent"};
	
	private static Random gen = new Random();
	
	private ArrayList<Person> citizens = new ArrayList<>();
	private Person bigCreditor = null;
	private int bigLawnsNumb = 0;

	public Country(int citizenAmm) throws Exception {
		super();
		if(citizenAmm < 2)
			throw new Exception("Not enough citizen");
			
		for (int i = 0; i < citizenAmm; i++)
			citizens.add(randomPerson());
		
		for (Person citizen : citizens) 
			citizen.setCreditor(findCreditor(citizen));
			
	}
	
	private Person findCreditor(Person citizen){
		Person lawner = citizens.get(gen.nextInt(citizens.size() - 1));
		if (lawner == citizen)
			return findCreditor(citizen);
		else
			return lawner;
	}
	
	private static Person randomPerson() {
		String name = RandomLib.randomStringFromSet(NAMES);
		return new Person(name, null);
	}

	private int countLawners(Person creditor){
		int lawners = 0;
		for (Person citizen : citizens)
			if (citizen.getCreditor() == creditor)
				lawners++;
		return lawners;
	}
	
	public void printBiggetCreditor() {
		if(bigCreditor != null){
			System.out.println(this.bigCreditor.getName());
			System.out.println(this.bigLawnsNumb);
		}
			
		int bigLawnNumb = 0;
		Person bigCred = null;
		for(Person citizen : citizens) {
			int lawnNumb = countLawners(citizen);
			if (lawnNumb > bigLawnNumb) {
				bigLawnNumb = lawnNumb;
				bigCred = citizen;
			}
			else if ((lawnNumb == bigLawnNumb) && (bigLawnNumb != 0))
				if (bigCred.getName().compareTo(citizen.getName()) < 0)
					bigCred = citizen;
		}
		this.bigCreditor = bigCred;
		System.out.println(bigCred.getName());
		System.out.println(bigLawnNumb);
	}
}
