package predicates;

import java.util.function.Predicate;

public class MultipleFive  implements Predicate<Integer>{

	@Override
	public boolean test(Integer t) {
		return t%5 == 0;
	}
	
}
