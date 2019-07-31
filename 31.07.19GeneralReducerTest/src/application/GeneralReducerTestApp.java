package application;

import java.util.ArrayList;

import accumulators.DoubleAverageAccumulator;
import car.Car;
import reducer.Reducers;

public class GeneralReducerTestApp {

	private static final int NUM_CARS = 10;

	public static void main(String[] args) {
		
		ArrayList<Car> garage = new ArrayList<>();
		for (int i = 0; i < NUM_CARS; i++)
			garage.add(Car.randomCar());
		for (Car c : garage)
			System.out.println(c);
		
		double averageEngine = 
				Reducers.reduce(garage,
						car -> car.getEngine(),
						() -> new DoubleAverageAccumulator(),
						(accum, engine) -> {
							accum.setSum(accum.getSum() + engine);
							accum.setCounter(accum.getCounter() + 1);
						},
						accum -> accum.getSum() / accum.getCounter()
						);

	}

}
