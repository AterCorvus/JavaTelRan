package application;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import dto.Employee;
import dto.Person;

public class ReflectionApp {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		
		/*Person person = new Person();
		
		Class<?> clasz1 = person.getClass();
		Class<?> clasz2 = Person.class;
		
		Person personNew = (Person) clasz1.newInstance();
		System.out.println(personNew);*/
		
		Class<?> classObject = Object.class;
		Class<?> classPerson = Person.class;
		Class<?> classEmployee = Employee.class;
		
		Employee employee = new Employee();
		System.out.println("employee: " + employee);
		
		Object object = classObject.cast(employee);
		System.out.println("employee: " + employee);
		
		classPerson.getDeclaredMethod("foo", int.class)
		.invoke(null, 333);
		
		
	}
	
}
