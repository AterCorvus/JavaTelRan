package application;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;

import dto.Car;

public class SupplierApp {
	public static void main(String[] args) {
		Supplier<Car> randomCar = () -> Car.randomCar();
		for (Car c : getRandomIterable(randomCar, 10))
			System.out.println(c);
		
		Random gen = new Random();
		Supplier<Integer> randomInt = () -> gen.nextInt(1000);
		
		for (int i : getRandomIterable(randomInt, 10))
			System.out.println(i);
	}
	
	public static <T> Iterable<T> getRandomIterable(Supplier<T> suplier, int n){
		ArrayList<T> alt = new ArrayList<>();
		for (int i = 0; i < n; i++)
			alt.add(suplier.get());
		return alt;
	}
}
