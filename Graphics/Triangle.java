package Graphics;

import java.util.Date;

/**
 * @author Niraj Gupta
 * Class to represent the Triangle by implementing the Shape interface.
 */
public class Triangle implements Shape{
	private Point origin;
	private double sideA, sideB, sideC, originDistance, height;
	private Date timeStamp;

	/**
	 * Parameterized Constructor
	 * @param origin : The point at which the triangle is to be drawn.
	 * @param sideA : The length of the base of the triangle.
	 * @param sideB : The length of the side of the triangle.
	 * @param sideC : The length of the side of the triangle.
	 */
	public Triangle(Point origin, double sideA, double sideB, double sideC, double height) {
		this.origin = origin;
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
		this.height = height;
		this.originDistance = Math.sqrt(Math.pow(origin.getX(), 2) + Math.pow(origin.getY(), 2));
	}

	public double getArea(){
		double semiPerimeter = getPerimeter() / 2;
		return Math.sqrt(semiPerimeter * (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC));
	}

	public double getPerimeter(){
		return (sideA + sideB + sideC);
	}

	public Point getOrigin(){
		return origin;
	}

	public boolean isPointEnclosed(Point point){
		boolean enclosed = false;
		double base = Math.sqrt(Math.pow(sideC, 2) - Math.pow(height, 2));
		Point b = new Point(origin.getX() + sideA, origin.getY());
		Point c = new Point(origin.getX() + base, origin.getY() + height);

		if (Math.abs(getArea() - ((getAreaByVertices(point, origin, b)) + getAreaByVertices(point, b, c) 
				+ getAreaByVertices(point, origin, c))) <= 0.001)
			enclosed = true;

		return enclosed;
	}

	private double getAreaByVertices(Point a, Point b, Point c) {
		return Math.abs((a.getX() * (b.getY() - c.getY()) + b.getX() * 
				(c.getY() - a.getY()) + c.getX() * (a.getY() - b.getY())) / 2.0);
	}

	public ShapeType getShapeType(){
		return ShapeType.TRIANGLE;
	}

	public double getOriginDistance(){
		return originDistance;
	}

	public Date getTimestamp(){
		return timeStamp;
	}

	public void setTimestamp(Date timestamp){
		this.timeStamp = timestamp;
	}
}
