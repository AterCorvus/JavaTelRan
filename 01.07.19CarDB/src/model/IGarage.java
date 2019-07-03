package model;

import dto.Car;

public interface IGarage {
	static enum SORTER_CAR {
		Model,
		Year,
		Engine
	};
	
	void fill(int numCar);
	
	boolean add(Car car);
	boolean contains(Car car);
	Car remove(int id);
	boolean remove(Car car);
	
	Car GetById(int id);
	Iterable<Car> allCars();
	Iterable<Car> allCars(String model);
	Iterable<Car> allCars(int minYear, int maxYear);
	Iterable<Car> allCars(double minEngine, double maxEngine);
	Iterable<Car> allCars(boolean ac);
	
	Iterable<Car> allCarsSorted(SORTER_CAR param);
}