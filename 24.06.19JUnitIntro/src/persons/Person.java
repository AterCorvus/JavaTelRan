package persons;

public class Person implements Comparable<Person>{
	
	private long id;
	private String name;
	private String city;
	
	public Person(long id, String name, String city) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public long getID() {
		return id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object person) {
		if (this == person)
			return true;
		if (person == null)
			return false;
		if (!(person instanceof Person))
			return false;
		Person other = (Person) person;
		if (id != other.id)
			return false;
		
		return true;
	}

	@Override
	public int compareTo(Person o) {
		
		return Long.compare(this.id, o.id);
	}
	
}
