package Graphics;

import java.util.List;

import Graphics.Shapes.ShapeType;

public class ShapeFactory{
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
