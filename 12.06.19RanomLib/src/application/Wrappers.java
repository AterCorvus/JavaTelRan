package application;

public class Wrappers {
	public static void main(String[] args) {
		System.out.println(Double.MAX_VALUE);
		System.out.println(Double.MIN_VALUE);
		System.out.println(Double.MAX_EXPONENT);
		System.out.println(Double.MIN_NORMAL);
		
		System.out.println(Long.toBinaryString(
				Double.doubleToLongBits(1.)));
		System.out.println(Long.toBinaryString(255L));
		
		double x = 1./16.;
		double sum = 0.;
		for(int i=0; i<16; ++i) sum = sum+x;
		
		System.out.println(Long.toBinaryString(
				Double.doubleToLongBits(sum)));
		
		System.out.println(Boolean.parseBoolean("tRue"));
		double oneThird = 1./3.;
		System.out.println(oneThird);
		System.out.println(cutTwo(oneThird));
	}
	
	public static double cutTwo(double orig){
		return ((int)(orig*100.))/100.;
	}
}
