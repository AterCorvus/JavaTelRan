package archive;

import java.util.Comparator;

import dto.Car;

public class EngineCarComp implements Comparator<Car> {

	@Override
	public int compare(Car c1, Car c2) {
		return Double.compare(c1.getEngine(), c2.getEngine());
	}
	
}
