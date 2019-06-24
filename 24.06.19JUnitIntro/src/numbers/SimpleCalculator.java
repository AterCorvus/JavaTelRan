package numbers;

public class SimpleCalculator implements ICalculator {

	@Override
	public int multiply(int op1, int op2) {
		return op1 * op2;
	}

	@Override
	public float multiply(float op1, float op2) {
		return op1 * op2;
	}

	@Override
	public int divide(int op1, int op2) {
		return op2 == 0 ? Integer.MAX_VALUE : op1 / op2;
	}

	@Override
	public float divide(float op1, float op2) {

		return op2 == 0 ? Float.NaN : op1 / op2;
	}

}
