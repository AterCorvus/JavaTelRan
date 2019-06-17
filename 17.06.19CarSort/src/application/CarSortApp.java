package application;

import java.util.Arrays;
import java.util.Comparator;

import car.Car;
import comparator.ACCarComparator;
import comparator.EngineCarComparator;
import comparator.ModelCarComparator;
import comparator.YearCarComparator;

public class CarSortApp {

	private static final int NUM_CARS = 200;

	public static void main(String[] args) {
		/*Car[] garage = new Car[NUM_CARS];
		for (int i = 0; i < garage.length; i++)
			garage[i] = Car.randomCar();*/
		
		Car[] garage = Car.getRandGarageArr(NUM_CARS);
		
		for (int i = 0; i < garage.length; i++)
			System.out.println(garage[i]);
		
		System.out.println("******************************************");
		
		Comparator<Car> modelComp = new ModelCarComparator();
		Comparator<Car> yearComp = new YearCarComparator();
		Comparator<Car> engineComp = new EngineCarComparator();
		Comparator<Car> acComp = new ACCarComparator();
		
		/*Arrays.sort(garage, modelComp
				.thenComparing(yearComp)
				.thenComparing(acComp));
		*/
		Arrays.sort(garage);
		
		for (int i = 0; i < garage.length; i++)
			System.out.println(garage[i]);
		
	}

}
