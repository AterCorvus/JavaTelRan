package application;

import java.util.stream.Stream;
import java.util.stream.Stream.Builder;

public class FlatMapApp {
	public static void main(String[] args) {
		/*TreeMap<String, TreeSet<Car>> map =
				Car.createCarStream(100)
				.collect(Collectors.toMap(
						(car)->car.getModel(),
						(car)->{
							TreeSet<Car> tsc = new TreeSet<>();
							tsc.add(car);
							return tsc;
						},
						(tree1, tree2)->{
							tree1.addAll(tree2);
							return tree1;
						},
						TreeMap :: new
				));

		map.values().stream()
					.flatMap(ts->ts.stream())
					.forEach(System.out :: println);
		*/
		Stream.iterate(10, n->n+1)
			  .limit(10)
			  .flatMap(n -> dividerStream(n))
			  .forEach((x)->System.out.print(x+" "));
	}

	private static Stream<Integer> dividerStream(Integer n) {
		Builder<Integer> builder = Stream.builder();
		int num = n;
		if(num < 4)
			return builder.build();
		int i = 0;
		for (i = 2; i*i < num && i*i > 0; i++) {
			if (num%i == 0) {
				builder.accept(i);
				builder.accept(num/i);
			}
		}
		if (i*i == num)
			builder.accept(i);
		return builder.build();
	}
}