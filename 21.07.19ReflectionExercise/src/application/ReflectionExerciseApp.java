package application;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Scanner;

import dto.Person;

public class ReflectionExerciseApp {
	
	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(new File("src/person.csv")))
		{   
		    sc.useDelimiter(";");
			Class pCls = Person.class;
			Method[] methodsPCls = pCls.getMethods();
	            	while(sc.hasNext()){
	            		for (Method method:methodsPCls) {
	            			if(method.getName().toLowerCase().indexOf("set") != -1) {
	            				Class<?> parType = method.getParameterTypes()[0];
			            		String inPar = sc.next();
			            		if (Integer.class.isAssignableFrom(inPar)) {
			                        value = (T) Integer.valueOf(input);
			                    } else if (clazz.isAssignableFrom(Boolean.class)) {
			                        value = (T) Boolean.valueOf(input);
			                    } else if (clazz.isAssignableFrom(Double.class)) {
			                        value = (T) Double.valueOf(input);
			                    } else {
			                        throw new IllegalArgumentException("Bad type.");
			                    }
	            	}
	            }
	            Method methodcall1 = cls.getDeclaredMethod("method2", 
	                    int.class); 
			}
		    person.setName(sc.next());
		    person.setAge(Integer.parseInt(sc.next()));
		    person.setHeight(Double.parseDouble(sc.next()));
		    person.setMarriage(Boolean.parseBoolean(sc.next()));
		    System.out.println(person);
		}
		catch(IOException ex){
            System.out.println(ex.getMessage());
        }
	}
	
}