package predicate;

import java.util.function.Predicate;

import car.Car;

public class YearRange implements Predicate<Car>{

	private int minYear;
	private int maxYear;

	public YearRange(int minYear, int maxYear) {
		super();
		this.minYear = minYear;
		this.maxYear = maxYear;
	}

	@Override
	public boolean test(Car c) {
		int year = c.getYear();
		return year >= minYear && year <= maxYear;
	}
	
	
}
