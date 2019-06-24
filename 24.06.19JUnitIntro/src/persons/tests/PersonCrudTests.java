package persons.tests;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import persons.Person;
import persons.implementation.PersonsArrayList;
import persons.interfaces.IPersons;

public class PersonCrudTests {

	private static final long ID1 = 1;
	private static final long ID2 = 2;
	private static final long ID3 = 3;
	private static final long IDN = 4;
	private static final String NAME1 = "Vasiya";
	private static final String NAME2 = "Moshe";
	private static final String NAME3 = "Sara";
	private static final String NAMEN = "Serg";
	private static final String CITY1 = "Haifa";
	private static final String CITY2 = "Rehovot";
	private static final String CITYN = "Tal-Aviv";
	Person person1;
	Person person2;
	Person person3;
	IPersons persons;
	
	@Before
	public void setUp() throws Exception {
		System.out.println("setup running...");
		person1 = new Person(ID1, NAME1, CITY1);
		person2 = new Person(ID2, NAME2, CITY2);
		person3 = new Person(ID3, NAME3, CITY2);
		persons = new PersonsArrayList();
		persons.addPerson(person1);
		persons.addPerson(person2);
		persons.addPerson(person3);
	}

	@After
	public void tearDown() throws Exception {
	}

	@BeforeClass
	public static void setUpClass() {
		System.out.println("before class running");
	}
	
	@AfterClass
	public static void tearDownClass() {
		System.out.println("after all tests running");
	}
	
	@Test
	public void testAddPerson() {
		assertFalse(persons.addPerson(person1));
		Person newPerson = new Person(IDN, NAMEN, CITYN);
		assertTrue(persons.addPerson(newPerson));
		assertEquals(newPerson, persons.getPerson(IDN));
	}

	@Test
	public void testRemovePerson() {
		assertFalse(persons.removePerson(IDN));
		assertTrue(persons.removePerson(ID1));
		assertNull(persons.getPerson(ID1));
	}

	@Test
	public void testGetPerson() {
		assertNull(persons.getPerson(IDN));
		assertEquals(person1, persons.getPerson(ID1));
	}

	private ArrayList<Person> getListPersons() {
		ArrayList<Person> res = new ArrayList<>();
		res.add(person1);
		res.add(person2);
		res.add(person3);
		return res;
	}
	
	@Test
	public void testGetAllPersons() {
		ArrayList<Person> listPersons = getListPersons();
		for(Person person: persons.getAllPersons()){
			assertTrue(listPersons.contains(person));
			listPersons.remove(person);
		}
		
		assertTrue(listPersons.isEmpty());
	}

	@Test
	public void testGetPersonsByCity() {
		Person[] arExpected = {
				person2, person3
		};
		
		Person[] actual = persons.getPersonsByCity(CITY2);
		Arrays.sort(actual);
		assertArrayEquals(arExpected, actual);
	}

	@Test
	public void testUpdatePersonCity() {
		assertTrue(persons.updatePersonCity(ID3, CITY1));
		assertEquals(CITY1, persons.getPerson(ID3).getCity());
	}

	@Test
	public void testSize() {
		assertEquals(3, persons.size());
	}

}
