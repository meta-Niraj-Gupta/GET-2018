package Graphics;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import Graphics.Shapes.ShapeType;

public class Screen{
	private List<Shapes> listOfShapes = new ArrayList<>();
	private final double XMAX, YMAX;

	public Screen(double xMax, double yMax){
		XMAX = xMax;
		YMAX = yMax;
	}

	public void addShape(Shapes shape){
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

	public void deleteShape(Shapes shape){
		if(listOfShapes.contains(shape)){
			listOfShapes.remove(shape);
		}else{
			throw new AssertionError("The shape is not present on screen!");
		}
	}

	public void deleteShapeType(ShapeType shapeType){
		boolean flag = false;
		List<Shapes> removeList = new ArrayList<>();

		for(Shapes shape : listOfShapes){
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

	public List<Shapes> sortByArea(){
		List<Shapes> sortedListByArea = new ArrayList<>(listOfShapes);
		int noOfObjects = listOfShapes.size();

		if(noOfObjects == 0){
			throw new AssertionError("List is empty! Cannot sort");
		}

		for(int i = 0; i < noOfObjects; i++){
			for(int j = 0; j < noOfObjects - 1 - i; j++){
				if(sortedListByArea.get(j).getArea() > sortedListByArea.get(j + 1).getArea()){
					Shapes temp = sortedListByArea.get(j);
					sortedListByArea.set(j, sortedListByArea.get(j + 1));
					sortedListByArea.set(j + 1, temp);
				}
			}
		}
		return sortedListByArea;
	}

	public List<Shapes> sortByPerimeter(){
		List<Shapes> sortedListByPerimeter = listOfShapes;
		int noOfObjects = sortedListByPerimeter.size();

		if(noOfObjects == 0){
			throw new AssertionError("List is empty! Cannot sort");
		}

		for(int i = 0; i < noOfObjects; i++){
			for(int j = 0; j < noOfObjects - 1 - i; j++){
				if (sortedListByPerimeter.get(j).getPerimeter() > sortedListByPerimeter.get(j + 1).getPerimeter()) {
					Shapes temp = sortedListByPerimeter.get(j);
					sortedListByPerimeter.set(j, sortedListByPerimeter.get(j + 1));
					sortedListByPerimeter.set(j + 1, temp);
				}
			}
		}
		return sortedListByPerimeter;
	}

	public List<Shapes> sortByOriginDistance(){
		List<Shapes> sortedListByOriginDistance = listOfShapes;
		int noOfObjects = sortedListByOriginDistance.size();

		if(noOfObjects == 0){
			throw new AssertionError("List is empty! Cannot sort");
		}

		for(int i = 0; i < noOfObjects; i++){
			for(int j = 0; j < noOfObjects - 1 - i; j++){
				if (sortedListByOriginDistance.get(j).getOriginDistance() > sortedListByOriginDistance.get(j + 1).getOriginDistance()) {
					Shapes temp = sortedListByOriginDistance.get(j);
					sortedListByOriginDistance.set(j, sortedListByOriginDistance.get(j + 1));
					sortedListByOriginDistance.set(j + 1, temp);
				}
			}
		}
		return sortedListByOriginDistance;
	}

	public List<Shapes> sortByTimestamp(){
		if (listOfShapes.size() == 0){
			throw new AssertionError("List is empty! Cannot sort");
		}
		return listOfShapes;
	}

	public List<Shapes> shapesEnclosingPoint(Point point){
		List<Shapes> listOfShapes = new ArrayList<>();

		if(point == null){
			throw new AssertionError("Enter a valid point");
		}

		for(Shapes shape : listOfShapes){
			if(shape.isPointEnclosed(point)){
				listOfShapes.add(shape);
			}
		}
		return listOfShapes;
	}
}
