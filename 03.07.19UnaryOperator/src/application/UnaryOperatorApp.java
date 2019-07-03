package application;

import java.util.function.UnaryOperator;

public class UnaryOperatorApp {

	public static void main(String[] args) {
		System.out.println(rootByBisection(1.5, 4.5, 1.e-12, x -> Math.sin(x)));

	}

	public static double rootByBisection(double a, double b, double eps,
			UnaryOperator<Double> fun){
		double left = a;
		double right = b;
		
		double sign = fun.apply(left) < 0. ? 1 : -1;
		
		double middle = 0.;
		while (right - left > eps){
			middle = (right + left)/2;
			if (sign * fun.apply(middle) > 0)
				right = middle;
			else 
				left = middle;
		}
		return (right + left)/2.;
	}
}
