package dto;

public class Dog extends Animal{

	private int age;

	public Dog(String name, int age) {
		super(name);
		this.age = age;
	}

	@Override
	public String toString() {
		return "Dog [age=" + age + "]";
	}
	
}
