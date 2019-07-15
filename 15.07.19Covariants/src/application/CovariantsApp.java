package application;

import dto.Animal;
import dto.Dog;


public class CovariantsApp {
	public static void main(String[] args) {
		Animal[] animals = {
				new Animal("Polkan"),
				new Animal("Zhuchka"),
				new Animal("Sharik")
		};
		
		display(animals);
		
		Dog[] dogs = {
				new Dog("Polkan", 5),
				new Dog("Zhuchka", 3),
				new Dog("Sharik", 4)
			};
		
		display(dogs);
	}
	
	public static void display(Animal[] animals) {
		for(Animal a : animals)
			System.out.println(a);
	}
}
