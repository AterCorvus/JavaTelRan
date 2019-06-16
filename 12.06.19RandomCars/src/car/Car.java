package car;

import randomLib.RandomLib;

public class Car {
	private static final String[] CAR_MODELS = {
			"Pobeda", "Volga", "Moskvich", "Zhiguli", "Zaporozhets", "Ford", "Toyota", "Kia",
			"Wolkswagen", "Fiat"
	};
	private static final int MIN_YEAR = 1980;
	private static final int MAX_YEAR = 2019;
	private static final int MIN_AC_YEAR = 2000;
	private static final double AC_PROBABILITY = 0.3;
	private static final double MIN_ENGINE = 1.;
	private static final double MAX_ENGINE = 2.5;
	private String model;
	private int year;
	private double engine;
	private boolean ac;
	
	public Car() {
		super();
	}
	
	public Car(String model, int year, double engine, boolean ac) {
		super();
		this.model = model;
		this.year = year;
		this.engine = engine;
		this.ac = ac;
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
		return "Car [model=" + model + ", year=" + year + ","
				+ String.format("%.1f", engine) + "," 
				+ (ac ? "yes" : "no" + "]");
	}
	
	public static Car randomCar(){
		String randomModel = RandomLib.randomStringFromSet(CAR_MODELS);
		int randomYear = RandomLib.nextInRange(MIN_YEAR, MAX_YEAR);
		double  randomEngine = RandomLib.nextInRange(MIN_ENGINE, MAX_ENGINE);
		boolean randomAC = randomYear < MIN_AC_YEAR ? false : RandomLib.randomBool(AC_PROBABILITY);
		
		return new Car(randomModel, randomYear, randomEngine, randomAC);
	}
}
