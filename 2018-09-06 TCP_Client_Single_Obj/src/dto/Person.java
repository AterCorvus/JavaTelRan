package dto;

import java.io.Serializable;
import java.util.Random;

public class Person implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static Random gen = new Random();
	
	private long id;
	private String name;
	private int age;
	private double weight;
	private boolean married;
	
	public Person(long id, String name, int age, double weight, boolean married) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.married = married;
	}
	
	static private String[] names = {"John","Jackob","Abraham","Robert","Richard","Michael"};
	
	public static Person getRandomPerson(){
		
		long randomId = 100000L +(long)gen.nextInt(899999);
		String randomName = names[gen.nextInt(names.length)];
		int randomAge = 30+gen.nextInt(20);
		double randomWeight = 60. + 30.*gen.nextDouble();
		boolean randomMarried = gen.nextBoolean();
		
		return new Person(randomId, randomName, randomAge, randomWeight, randomMarried);
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + 
				", weight=" + String.format("%.1f",weight) + ", married=" + married+ "]";
	}
	
	

}
