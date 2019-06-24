package application;

import circles.Circle;

public class CirclesApp {

	public static void main(String[] args) {
		Circle c1 = new Circle(3, 5 , 5);
		Circle c2 = new Circle(-3, 4, 5);
		Circle c3 = new Circle(2, -1, 6);
		
		System.out.println(circles.Circle.haveCommon(c1, c2, c3));
	}

}
