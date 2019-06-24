package persons.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import persons.Person;

public class PersonTests {
	
	private static final long ID1 = 123;
	private static final String NAME1 = "Moshe";
	private static final String CITY1 = "Haifa";
	private static final String NAME2 = "Vasia";
	private static final String CITY2 = "Rehovot";
	Person person;

	@Before
	public void setUp() throws Exception {
		person = new Person(ID1, NAME1, CITY1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPerson() {
		Person person2 = new Person(ID1, NAME1, CITY1);
		assertEquals(person, person2);
	}

	@Test
	public void testGetName() {
		assertEquals(NAME1, person.getName());
	}

	@Test
	public void testSetName() {
		person.setName(NAME2);
		assertEquals(NAME2, person.getName());
	}

	@Test
	public void testGetCity() {
		assertEquals(CITY1, person.getCity());
	}

	@Test
	public void testSetCity() {
		person.setCity(CITY2);
		assertEquals(CITY2, person.getCity());
	}

	@Test
	public void testGetId() {
		assertEquals(ID1, person.getID());
	}

}
