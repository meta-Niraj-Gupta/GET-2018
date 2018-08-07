package Graphics;

import java.util.Date;

/**
 * @author Niraj Gupta
 * Interface to implement the basic shapes like circle, square, triangle, rectangle and regular polygon and 
 * Performing different operations.
 *
 */
public interface Shape{

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
	 * @param point : The point which is to be checked.
	 * @return : True if the given point lie inside the shape, false otherwise.
	 */
	boolean isPointEnclosed(Point point);

	/**
	 * Method to get the type of the shape.
	 * @return : The type of the shape.
	 */
	ShapeType getShapeType();

	/**
	 * Method to get the distance of the shape from the origin say P(X, Y) to the origin of the screen i.e. P(0, 0).
	 * @return : The distance between the origin of the shape and the screen.
	 */
	double getOriginDistance();

	/**
	 * Method to get the time at which the shape is added to the screen.
	 * @return : The time at which the shape has been added to the screen.
	 */
	Date getTimestamp();

	/**
	 * Method to set the time at which the shape is added on the screen.
	 * @param timestamp : The instance of time at which the shape has been added on the screen
	 */
	void setTimestamp(Date timestamp);
}
