package archive;

import java.util.Comparator;

import dto.Car;

public class NaturalCarComp implements Comparator<Car>{
	public static final Comparator<Car> naturalComparator = 
			(new ModelCarComp())
			.thenComparing(new YearCarComp())
			.thenComparing(new EngineCarComp())
			.thenComparing(new IdCarComp());

	@Override
	public int compare(Car c1, Car c2) {
		return naturalComparator.compare(c1, c2);
	}
}
