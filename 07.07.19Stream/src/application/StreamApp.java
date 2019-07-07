package application;

import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

import dto.Car;
import model.Garage;

public class StreamApp {
	public static void main(String[] args) {
		Garage garage = new Garage();
		garage.fill(20);
		
		Builder<Car> garageBuilder = Stream.builder();
		for (Car c : garage.allCars())
			garageBuilder.accept(c);
		garageBuilder.build()
					 .filter(c -> c.getModel().equals("Toyota"))
					 .forEach((c) -> System.out.println(c));
	}
}
