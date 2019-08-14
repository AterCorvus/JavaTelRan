package dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor

public class Employee extends Person {
	@Getter private String company;
	@Getter private int salary;
	
	public Employee(int id, Address address, String name, LocalDate birthdate, String company, int salary) {
		super(id, address, name, birthdate);
		this.company = company;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [company=" + company + ", salary=" + salary + "] super: "+super.toString();
	}
	
	
	
	/*public void setCompany(String company) {
		this.company = company;
	}

	

	public void setSalary(int salary) {
		this.salary = salary;
	}*/

	

}
