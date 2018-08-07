package Graphics;

import java.util.Date;

/**
 * @author Niraj Gupta
 * Class to represent the Circle by implementing the Shape interface.
 *
 */
public class Circle implements Shapes{
	private Point point;
	private double radius;
	private Date timeStamp;
	private double originDistance;

	/**
	 * Parameterized Constructor
	 * @param point : The center of the circle.
	 * @param radius : The length of the circle from the center to the boundary of the circle.
	 */
	public Circle(Point point, double radius){
		this.point = point;
		this.radius = radius;
		this.originDistance = Math.sqrt(Math.pow(getOrigin().getX(), 2) + Math.pow(getOrigin().getY(), 2));
	}

	public double getArea(){
		return Math.PI * radius * radius;
	}

	public double getPerimeter(){
		return 2 * Math.PI * radius;
	}

	public Point getOrigin(){
		double distance = Math.sqrt(point.getX() * point.getX() + point.getY() * point.getY());

		return new Point((distance - radius) * point.getX() / ((distance - radius) + radius), 
				(distance - radius) * point.getY() / ((distance - radius) + radius));
	}

	public boolean isPointEnclosed(Point points){
		double distance = Math.sqrt(Math.abs(points.getX() - point.getX()) * Math.abs(points.getX() - point.getX())) 
				+ Math.sqrt(Math.abs(points.getY() - point.getY()) * Math.abs(points.getY() - point.getY()));
		return distance < radius;
	}

	public ShapeType getShapeType(){
		return ShapeType.CIRCLE;
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

	/**
	 * @return : The center point of the circle.
	 */
	public Point getPoint(){
		return point;
	}

	/**
	 * @return : The radius of the circle.
	 */
	public double getRadius(){
		return radius;
	}
}
