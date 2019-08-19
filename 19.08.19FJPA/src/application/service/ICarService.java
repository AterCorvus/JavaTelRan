package application.service;

import java.util.List;

import application.entities.CarEntity;

public interface ICarService {
	
	boolean addCar(CarEntity car);
	void addManyCars(List<CarEntity> listCar);
	
}
