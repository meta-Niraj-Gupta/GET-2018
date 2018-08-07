package Graphics;

import java.util.List;

import Graphics.Shapes.ShapeType;

/**
 * @author Niraj Gupta
 * Class to implement the abstract factory to create the reference to the object of shape type like
 * Rectangle, Square, Circle, Regular Polygon and Triangle.
 */
public class ShapeFactory{

	/**
	 * Method to create the reference to the object of shape type on the basis of requirement.
	 * @param shapeType : The type of the shape whose object has to be created.
	 * @param point : The point at which the shape is placed on the screen.
	 * @param list : The list containing the basic attributes of the shape. For example the list contain length of side if the 
	 * 				 shape type is square or radius if the shape type is circle etc.
	 * @return : The reference to the object of the shape type.
	 */
	public static Shapes createShape(ShapeType shapeType, Point point, List<Integer> list) {
		Shapes shape = null;
		switch (shapeType) {
		case CIRCLE:
			shape = new Circle(point, list.get(0));
			break;
		case RECTANGLE:
			shape = new Rectangle(point, list.get(0), list.get(1));
			break;
		case REGULAR_POLYGON:
			shape = new RegularPolygon(point, list.get(0), list.get(1));
			break;
		case SQUARE:
			shape = new Square(point, list.get(0));
			break;
		case TRIANGLE:
			shape = new Triangle(point, list.get(0), list.get(1), list.get(2), list.get(3));
			break;
		default:
			throw new AssertionError("Invalid Input");

		}
		return shape;
	}
}
