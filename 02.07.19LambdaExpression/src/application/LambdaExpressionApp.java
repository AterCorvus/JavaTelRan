package application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;

import dto.Car;

public class LambdaExpressionApp {
	private static final int NUM_NUM = 20;

	public static void main(String[] args) {
		ArrayList<Car> alc = new ArrayList<>();
		for (int i = 0; i < NUM_NUM; i++)
			alc.add(Car.randomCar());
		for (Car c : alc)
			System.out.println(c);
		System.out.println("***************************************");
		
		//Collections.sort(alc, new YearCarComp());
		/*Collections.sort(alc, new Comparator<Car>(){

			@Override
			public int compare(Car c1, Car c2) {
				return c1.getYear() - c2.getYear();
			}
		});*/
		
		// Lambda expression
		//Comparator<Car> yearC = (Car c1, Car c2) -> c1.getYear() - c2.getYear();
		Comparator<Car> yearC = (c1, c2) -> c1.getYear() - c2.getYear();
		Collections.sort(alc, yearC);
		
		for (Car c : alc)
			System.out.println(c);
		System.out.println("***************************************");
		
		String model = "Toyota";
		//Predicate<Car> namePredicate = (Car c) -> c.getModel().equals(model );
		//Predicate<Car> namePredicate = (c) -> c.getModel().equals(model );
		Predicate<Car> namePredicate = c -> c.getModel().equals(model );
		alc.removeIf(namePredicate.negate());
		for (Car c : alc)
			System.out.println(c);
	}
}
