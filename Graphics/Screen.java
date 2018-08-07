package Graphics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Graphics.Shape.ShapeType;

/**
 * @author Niraj Gupta
 * Class to represent the screen on which the shapes are drawn.
 */
public class Screen{
	private List<Shape> listOfShapes = new ArrayList<>();
	private final double XMAX, YMAX;

	/**
	 * Parameterized Constructor
	 * @param xMax : The maximum length of the screen.
	 * @param yMax : The maximum breadth of the screen.
	 */
	public Screen(double xMax, double yMax){
		XMAX = xMax;
		YMAX = yMax;
	}

	/**
	 * Method to add shape on the screen
	 * @param shape : The shape which is to be added on the screen.
	 */
	public void addShape(Shape shape){
		if(shape == null){
			throw new AssertionError("Null object");
		}
		Point origin = shape.getOrigin();
		if(origin.getX() < 0 || origin.getX() > XMAX || origin.getY() < 0 || origin.getY() > YMAX){
			throw new AssertionError("Cannot create shape outside the screen");
		}
		listOfShapes.add(shape);
		shape.setTimestamp(new Date());
	}

	/**
	 * Method to remove the shape from the screen.
	 * @param shape : The shape which is to be removed from the screen.
	 */
	public void deleteShape(Shape shape){
		if(listOfShapes.contains(shape)){
			listOfShapes.remove(shape);
		}else{
			throw new AssertionError("The shape is not present on screen!");
		}
	}

	/**
	 * Method to remove all the shapes from the screen belonging to a particular screen type.
	 * @param shapeType : The type of the shape which is to be removed.
	 */
	public void deleteShapeType(ShapeType shapeType){
		boolean flag = false;
		List<Shape> removeList = new ArrayList<>();

		for(Shape shape : listOfShapes){
			if(shape.getShapeType() == shapeType){
				flag = true;
				removeList.add(shape);
			}
		}
		listOfShapes.removeAll(removeList);
		if(!flag){
			throw new AssertionError("No object of the given type!");
		}
	}

	/**
	 * Method to sort the shapes on the basis of their area.
	 * @return : The sorted list of shape.
	 */
	public List<Shape> sortByArea(){
		List<Shape> sortedListByArea = new ArrayList<>(listOfShapes);
		int noOfObjects = listOfShapes.size();

		if(noOfObjects == 0){
			throw new AssertionError("List is empty! Cannot sort");
		}

		for(int i = 0; i < noOfObjects; i++){
			for(int j = 0; j < noOfObjects - 1 - i; j++){
				if(sortedListByArea.get(j).getArea() > sortedListByArea.get(j + 1).getArea()){
					Shape temp = sortedListByArea.get(j);
					sortedListByArea.set(j, sortedListByArea.get(j + 1));
					sortedListByArea.set(j + 1, temp);
				}
			}
		}
		return sortedListByArea;
	}

	/**
	 * Method to sort the shapes on the basis of their perimeter.
	 * @return : The sorted list of the shape.
	 */
	public List<Shape> sortByPerimeter(){
		List<Shape> sortedListByPerimeter = listOfShapes;
		int noOfObjects = sortedListByPerimeter.size();

		if(noOfObjects == 0){
			throw new AssertionError("List is empty! Cannot sort");
		}

		for(int i = 0; i < noOfObjects; i++){
			for(int j = 0; j < noOfObjects - 1 - i; j++){
				if (sortedListByPerimeter.get(j).getPerimeter() > sortedListByPerimeter.get(j + 1).getPerimeter()) {
					Shape temp = sortedListByPerimeter.get(j);
					sortedListByPerimeter.set(j, sortedListByPerimeter.get(j + 1));
					sortedListByPerimeter.set(j + 1, temp);
				}
			}
		}
		return sortedListByPerimeter;
	}

	/**
	 * Method to sort the shapes based on their distance from the origin of the screen.
	 * @return : The sorted list of the shape.
	 */
	public List<Shape> sortByOriginDistance(){
		List<Shape> sortedListByOriginDistance = listOfShapes;
		int noOfObjects = sortedListByOriginDistance.size();

		if(noOfObjects == 0){
			throw new AssertionError("List is empty! Cannot sort");
		}

		for(int i = 0; i < noOfObjects; i++){
			for(int j = 0; j < noOfObjects - 1 - i; j++){
				if (sortedListByOriginDistance.get(j).getOriginDistance() > sortedListByOriginDistance.get(j + 1).getOriginDistance()) {
					Shape temp = sortedListByOriginDistance.get(j);
					sortedListByOriginDistance.set(j, sortedListByOriginDistance.get(j + 1));
					sortedListByOriginDistance.set(j + 1, temp);
				}
			}
		}
		return sortedListByOriginDistance;
	}

	/**
	 * Method to sort the shape on the basis of the time on which they were added on the screen.
	 * @return : The sorted list of the shape.
	 */
	public List<Shape> sortByTimestamp(){
		if (listOfShapes.size() == 0){
			throw new AssertionError("List is empty! Cannot sort");
		}
		return listOfShapes;
	}

	/**
	 * Method to Check if the given point to draw the shape doesn't overlap the existing shape.
	 * @param point : The point where the shape has to be drawn.
	 * @return : The list of the shape.
	 */
	public List<Shape> shapesEnclosingPoint(Point point){
		List<Shape> listOfShapes = new ArrayList<>();

		if(point == null){
			throw new AssertionError("Enter a valid point");
		}

		for(Shape shape : listOfShapes){
			if(shape.isPointEnclosed(point)){
				listOfShapes.add(shape);
			}
		}
		return listOfShapes;
	}
}
