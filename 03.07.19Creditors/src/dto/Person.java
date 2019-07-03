package dto;

public class Person {
	
	private String name;
	private Person creditor;
	
	public Person(String name, Person creditor) {
		super();
		this.name = name;
		this.creditor = creditor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getCreditor() {
		return creditor;
	}

	public void setCreditor(Person creditor) {
		this.creditor = creditor;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
}
