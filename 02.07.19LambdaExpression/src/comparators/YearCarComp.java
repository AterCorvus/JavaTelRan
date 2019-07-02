package comparators;

import java.util.Comparator;

import dto.Car;

public class YearCarComp implements Comparator<Car> {

	@Override
	public int compare(Car c1, Car c2) {
		return Integer.compare(c1.getYear(), c2.getYear());
	}

}
