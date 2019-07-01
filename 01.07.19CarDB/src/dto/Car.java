package dto;

import java.util.Comparator;

import comparators.EngineCarComp;
import comparators.ModelCarComp;
import comparators.YearCarComp;
import randomLib.RandomLib;

public class Car implements Comparable<Car>{
	public static final Comparator<Car> naturalComparator = 
			(new ModelCarComp())
			.thenComparing(new YearCarComp())
			.thenComparing(new EngineCarComp());
	
	private static final String[] CAR_MODELS = { "Pobeda", "Volga", "Moskvich", "Zhiguli", "Zaporozhets", "Ford",
			"Toyota", "Kia", "Wolkswagen", "Fiat" };
	private static final int MIN_YEAR = 1980;
	private static final int MAX_YEAR = 2019;
	private static final int MIN_AC_YEAR = 2000;
	private static final double AC_PROBABILITY = 0.3;
	private static final double MIN_ENGINE = 1.;
	private static final double MAX_ENGINE = 2.5;
	
	private int id;
	private String model;
	private int year;
	private double engine;
	private boolean ac;

	public Car() {
		super();
	}

	public Car(int id,String model, int year, double engine, boolean ac) {
		super();
		this.id = id;
		this.model = model;
		this.year = year;
		this.engine = engine;
		this.ac = ac;
	}

	public int getID(){
		return id;
	}
	
	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public double getEngine() {
		return engine;
	}

	public void setEngine(double engine) {
		this.engine = engine;
	}

	public boolean isAc() {
		return ac;
	}

	public void setAc(boolean ac) {
		this.ac = ac;
	}

	@Override
	public String toString() {
		return "Car [" + 
				"id=" + id + 
				", model=" + model + 
				", year=" + year + 
				", engine=" + String.format("%.1f", engine) + 
				", " + (ac ? "yes" : "no") + "]";
	}

	public static Car randomCar() {
		int randomId = RandomLib.nextInRange(100000000, 999999999);
		String randomModel = RandomLib.randomStringFromSet(CAR_MODELS);
		int randomYear = RandomLib.nextInRange(MIN_YEAR, MAX_YEAR);
		double randomEngine = RandomLib.nextInRange(MIN_ENGINE, MAX_ENGINE);
		randomEngine = ((int)(randomEngine*10.) / 10.);
		boolean randomAC = randomYear < MIN_AC_YEAR ? false : RandomLib.randomBool(AC_PROBABILITY);

		return new Car(randomId, randomModel, randomYear, randomEngine, randomAC);
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (ac ? 1231 : 1237);
		long temp;
		temp = Double.doubleToLongBits(engine);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + id;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + year;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		if (ac != other.ac)
			return false;
		if (Double.doubleToLongBits(engine) != Double.doubleToLongBits(other.engine))
			return false;
		if (id != other.id)
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (year != other.year)
			return false;
		return true;
	}

	@Override
	public int compareTo(Car other) {
		return naturalComparator.compare(this, other);
	}
	
	public static Car[] getRandGarageArr(int n) {
		if (n < 0) n = 0;
		Car[] result = new Car[n];
		for (int i = 0; i < n; i++) result[i] = randomCar();
		return result;
	}

}