package dto;

import java.util.Comparator;

public class CarComparators {
	public static Comparator<Car> engineComparator =
			(c1, c2) -> Double.compare(c1.getEngine(), c2.getEngine());
			
	public static Comparator<Car> yearComparator =
			(c1, c2) -> Integer.compare(c1.getYear(), c2.getYear());
			
	public static Comparator<Car> modelComparator =
			(c1, c2) -> -c1.getModel().compareTo(c2.getModel());
			
	public static Comparator<Car> idComparator =
			(c1, c2) -> Integer.compare(c1.getID(), c2.getID());
			
	public static Comparator<Car> naturalComparator =
			modelComparator
			.thenComparing(yearComparator)
			.thenComparing(engineComparator)
			.thenComparing(idComparator);
}
