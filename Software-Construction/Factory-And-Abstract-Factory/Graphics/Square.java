package Graphics;

import java.util.Date;

/**
 * @author Niraj Gupta
 * Class to represent the Square by implementing the Shape interface.
 */
public class Square implements Shapes{
	private Date timeStamp;
	private Point origin;
	private double side, originDistance;

	/**
	 * Parameterized Constructor
	 * @param origin : The point at which the square is to be drawn.
	 * @param side : The length of the side of the square.
	 */
	public Square(Point origin, double side) {
		this.origin = origin;
		this.side = side;
		this.originDistance = Math.sqrt(Math.pow(origin.getX(), 2) + Math.pow(origin.getY(), 2));
	}

	public double getArea(){
		return side * side;
	}

	public double getPerimeter(){
		return 4 * side;
	}

	public Point getOrigin(){
		return origin;
	}

	public boolean isPointEnclosed(Point point){
		return point.getX() >= origin.getX() && point.getX() <= side + origin.getX() && 
				point.getY() >= origin.getY() && point.getY() <= side + origin.getY();
	}

	public ShapeType getShapeType(){
		return ShapeType.SQUARE;
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
