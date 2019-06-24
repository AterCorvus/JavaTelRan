package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import numbers.ICalculator;
import numbers.SimpleCalculator;

public class CalculatorTest {

	ICalculator calculator = new SimpleCalculator();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMultiplyIntInt() {
		assertEquals(4, calculator.multiply(2, 2));
		assertEquals(-4, calculator.multiply(-2, 2));
		assertEquals(-2, calculator.multiply(Integer.MAX_VALUE, 2));
		assertEquals(4, calculator.multiply(-2, -2));
	}

	@Test
	public void testMultiplyFloatFloat() {
		assertEquals(4.4, calculator.multiply(2.2f, 2), 0.1);
	}

	@Test
	public void testDivideIntInt() {
		assertEquals(2, calculator.divide(4, 2));
		assertEquals(-2, calculator.divide(-4, 2));
		assertEquals(Integer.MAX_VALUE, calculator.divide(4, 0));
		assertEquals(2, calculator.divide(-4, -2));
	}

	@Test
	public void testDivideFloatFloat() {
		assertEquals(2.2, calculator.divide(4.4f, 2), 0.1);
		assertFalse(Float.isFinite(calculator.divide(4.4f, 0)));
	}

}
