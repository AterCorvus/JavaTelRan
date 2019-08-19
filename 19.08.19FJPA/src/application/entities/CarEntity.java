package application.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import dto.Car;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

@Entity
@Table(name="car")
public class CarEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String model;
	private LocalDate productionDate;
	private double engine;
	private boolean ac;
	
	public CarEntity(String model, LocalDate productionDate, double engine, boolean ac) {
		super();
		this.model = model;
		this.productionDate = productionDate;
		this.engine = engine;
		this.ac = ac;
	}
	
	public CarEntity (Car car) {
		this(car.getModel(), car.getProductionDate(),
				car.getEngine(), car.isAc());
	}
	
	public Car getCar() {
		return new Car(model, productionDate, engine, ac);
	}
	
}
