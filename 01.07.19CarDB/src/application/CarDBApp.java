package application;

import dto.Car;
import model.Garage;
import model.IGarage.SORTER_CAR;

public class CarDBApp {
	public static void main(String[] args) {
		Garage garage = new Garage();
		garage.fill(2000);
		for (Car c : garage.allCars(1.8, 2.3))
			System.out.println(c);
	}
}
