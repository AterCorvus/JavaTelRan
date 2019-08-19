package application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import application.entities.CarEntity;
import application.repo.CarJpaRepository;

@Service
public class CarService implements ICarService {
	
	@Autowired
	CarJpaRepository carsRepo;
	
	public boolean addCar(CarEntity car) {
		if (carsRepo.existsById(car.getId())) return false;
		carsRepo.save(car);
		return true;
	}

	@Override
	public void addManyCars(List<CarEntity> listCar) {
		carsRepo.saveAll(listCar);
	}
	
}
