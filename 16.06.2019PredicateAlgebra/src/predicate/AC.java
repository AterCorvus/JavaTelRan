package predicate;

import java.util.function.Predicate;

import car.Car;

public class AC implements Predicate<Car>{

	@Override
	public boolean test(Car c) {
		
		return c.isAc();
	}
	
}
