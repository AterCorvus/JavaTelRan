package application.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import application.entities.CarEntity;
import application.service.ICarService;
import dto.Car;

@RestController
public class CarController {

	@Autowired
	ICarService service;
	
	@GetMapping("/addOneRandomCar")
	public boolean addOneRandomCar() {
		return service.addCar(new CarEntity(Car.getRandomCar()));
	}
	
	@GetMapping("/addManyRandomCars/{num}")
	public String AddManyRandomCars(@PathVariable int num) {
		ArrayList<CarEntity> listCar = new ArrayList<>();
		for (int i = 0; i < num; i++)
			listCar.add(new CarEntity(Car.getRandomCar()));
		service.addManyCars(listCar);
		return "OK";
	}
	
}
