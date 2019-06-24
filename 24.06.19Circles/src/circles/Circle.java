package circles;

public class Circle {
	private Point center;
	private double radiuos;

	public Circle(double x, double y, double radiuos) {
		super();
		this.center = new Point(x, y);
		this.radiuos = radiuos;
	}

	public Point getCenter() {
		return center;
	}

	public double getRadiuos() {
		return radiuos;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((center == null) ? 0 : center.hashCode());
		long temp;
		temp = Double.doubleToLongBits(radiuos);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Circle other = (Circle) obj;
		if (center == null) {
			if (other.center != null)
				return false;
		} else if (!center.equals(other.center))
			return false;
		if (Double.doubleToLongBits(radiuos) != Double.doubleToLongBits(other.radiuos))
			return false;
		return true;
	}
	
	private static boolean isInside(double radDiff, double xDist, double yDist) {
		boolean radInX = (radDiff - xDist) <= 0;
		boolean radInY = (radDiff - yDist) <= 0;
		return !((radInX == true) && (radInY == true));
	}
	
	private static boolean haveCommon(Circle c1, Circle c2) {
		if (c1.equals(c2))
			return true;
		
		double radDiff = Math.abs(c1.radiuos - c2.radiuos);
		double xDist = Math.abs(c1.center.getX() - c2.center.getX());
		double yDist = Math.abs(c1.center.getY() - c2.center.getY());
		if(isInside(radDiff, xDist, yDist))
			return false;
		
		boolean comX = (xDist - c1.radiuos - c2.radiuos) <= 0;
		boolean comY = (yDist - c1.radiuos - c2.radiuos) <= 0;
		return (comX == true) && (comY == true);
	}

	public static boolean haveCommon(Circle c1, Circle c2, Circle c3) {
		return haveCommon(c1, c2) && haveCommon(c2, c3) && haveCommon(c1, c3);
	}
}
