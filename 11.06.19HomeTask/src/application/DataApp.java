package application;

import java.math.BigInteger;

public class DataApp {
	public static void main(String[] args) {
		BigInteger v2 = new BigInteger("5386", 12);
		System.out.println(v2.toString(21));
	}
}
