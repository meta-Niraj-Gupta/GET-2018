package Graphics;

import java.util.Date;

/**
 * @author Niraj Gupta
 * Class to represent the Rectangle by implementing the Shape interface.
 *
 */
public class Rectangle implements Shape{
	private Date timeStamp;
	private Point origin;
	private double length, breadth, originDistance;

	/**
	 * Parameterized Constructor
	 * @param origin : The point at which the rectangle is to be drawn on the screen.
	 * @param length : The length of the rectangle.
	 * @param breadth : The breadth of the rectangle.
	 */
	public Rectangle(Point origin, double length, double breadth){
		this.origin = origin;
		this.length = length;
		this.breadth = breadth;
		this.originDistance = Math.sqrt(Math.pow(origin.getX(), 2) + Math.pow(origin.getY(), 2));
	}

	/**
	 * @return : The point at which the rectangle is drawn.
	 */
	public Point getPoint(){
		return origin;
	}

	public double getArea(){
		return length * breadth;
	}

	public double getPerimeter(){
		return 2 * (length + breadth);
	}

	public Point getOrigin(){
		return origin;
	}

	public boolean isPointEnclosed(Point point){
		return point.getX() >= origin.getX() && point.getX() <= length + origin.getX() 
				&& point.getY() >= origin.getY() && point.getY() <= breadth+origin.getY();
	}

	public ShapeType getShapeType(){
		return ShapeType.RECTANGLE;
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
