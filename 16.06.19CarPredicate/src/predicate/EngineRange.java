package predicate;

import java.util.function.Predicate;

import car.Car;

public class EngineRange implements Predicate<Car> {

	private double minEngine;
	private double maxEngine;

	public EngineRange(double minEngine, double maxEngine) {
		super();
		this.minEngine = minEngine;
		this.maxEngine = maxEngine;
	}

	@Override
	public boolean test(Car c) {
		double engine = c.getEngine();
		return engine >= minEngine && engine >= maxEngine;
	}

}
