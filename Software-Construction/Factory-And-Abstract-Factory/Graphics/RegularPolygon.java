package Graphics;

import java.util.Date;

public class RegularPolygon implements Shapes{
	private Point origin;
	private double length;
	private int noOfSide;
	private double originDistance;
	private Date timeStamp;


	public RegularPolygon(Point origin, double length, int noOfSide){
		this.origin = origin;
		this.length = length;
		this.noOfSide = noOfSide;
		this.originDistance = Math.sqrt(Math.pow(origin.getX(), 2) + Math.pow(origin.getY(), 2));
	}

	public double getArea(){
		double apothem = length / (2 * Math.tan(Math.toRadians(180 / noOfSide)));
		return 0.5 * apothem * getPerimeter();
	}

	public double getPerimeter(){
		return length * noOfSide;
	}

	public Point getOrigin(){
		return origin;
	}

	public boolean isPointEnclosed(Point point){
		return false;
	}

	public ShapeType getShapeType(){
		return ShapeType.REGULAR_POLYGON;
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
