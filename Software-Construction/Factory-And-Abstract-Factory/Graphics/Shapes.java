package Graphics;

import java.util.Date;

/**
 * @author Niraj Gupta
 * Interface to implement the basic shapes like circle, square, triangle, rectangle and regular polygon and 
 * Performing different operations.
 *
 */
public interface Shapes{
	
	/**
	 * @author Niraj Gupta
	 * enum to store the shape type like rectangle, triangle, circle, square and regular polygon.
	 */
	public enum ShapeType{
		SQUARE, RECTANGLE, CIRCLE, TRIANGLE, REGULAR_POLYGON;
	}
	
	/**
	 * Method to get the area of the shape.
	 * @return : The area of the shape.
	 */
	double getArea();
	
	/**
	 * Method to get the perimeter of the shape.
	 * @return : The perimeter of the shape.
	 */
	double getPerimeter();
	
	/**
	 * Method to get the point from where the shape is originated.
	 * @return : The point from where the shape start on the screen.
	 */
	Point getOrigin();
	
	/**
	 * Method to check if the given point lies inside the given shape or not.
	 * @param point : the point which is to be checked.
	 * @return : The 
	 */
	boolean isPointEnclosed(Point point);

	ShapeType getShapeType();

	double getOriginDistance();

	Date getTimestamp();

	void setTimestamp(Date timestamp);
}
