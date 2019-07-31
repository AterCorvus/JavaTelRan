package accumulators;

public class DoubleAverageAccumulator {

	private double sum = 0.;
	private int counter = 0;
	
	public DoubleAverageAccumulator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DoubleAverageAccumulator(double sum, int counter) {
		super();
		this.sum = sum;
		this.counter = counter;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	
}
