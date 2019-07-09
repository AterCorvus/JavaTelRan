package application;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import dto.Car;

public class GropingByApp {
	public static void main(String[] args) {
		Map<String, List<Car>> map = Car.createCarStream(20)
			.collect(Collectors.groupingBy(c -> classifier(c)));
		
		for (String s : map.keySet()) {
			System.out.println(s);
			for (Car c : map.get(s))
				System.out.println("\t" + c);
		}
	}

	private static String classifier(Car c) {
		if (c.getYear() < 1995)
			return "Old";
		else if (c.getYear() < 2010)
			return "Medium";
		else
			return "New";
	}
}
