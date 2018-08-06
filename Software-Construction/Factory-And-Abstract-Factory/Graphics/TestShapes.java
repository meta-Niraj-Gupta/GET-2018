package Graphics;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import Graphics.Shapes.ShapeType;

public class TestShapes{

	@Test
	public void rectangle_HappyFlow(){
		Shapes rectangle = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), Arrays.asList(4, 2));

		assertEquals(8.0, rectangle.getArea(), 0.01);
		assertEquals(12, rectangle.getPerimeter(), 0.01);
		assertTrue(rectangle.isPointEnclosed(new Point(2, 1)));
		assertFalse(rectangle.isPointEnclosed(new Point(5, 5)));
	}

	@Test
	public void square_HappyFlow(){
		Shapes square = ShapeFactory.createShape(ShapeType.SQUARE, new Point(1, 1), Arrays.asList(4));

		assertEquals(16.0, square.getArea(), 0.01);
		assertEquals(16.0, square.getPerimeter(), 0.01);
		assertTrue(square.isPointEnclosed(new Point(2, 1)));
		assertTrue(square.isPointEnclosed(new Point(5, 5)));
	}

	@Test
	public void triangle_HappyFlow(){
		Shapes triangle = ShapeFactory.createShape(ShapeType.TRIANGLE, new Point(1, 1), Arrays.asList(4, 3, 2, 1));

		assertEquals(2.904, triangle.getArea(), 0.001);
		assertEquals(9, triangle.getPerimeter(), 0.001);
		assertFalse(triangle.isPointEnclosed(new Point(2, 0)));
		assertFalse(triangle.isPointEnclosed(new Point(5, 0)));
	}


	@Test
	public void circle_HappyFlow(){
		Shapes circle = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(1, 1), new ArrayList<Integer>(){{
			add(4);
		}});

		assertEquals(50.265, circle.getArea(), 0.001);
		assertEquals(25.133, circle.getPerimeter(), 0.001);
		assertTrue(circle.isPointEnclosed(new Point(2, 1)));
		assertFalse(circle.isPointEnclosed(new Point(10, 5)));
	}

	@Test
	public void addShape_HappyFlow(){

		Screen screen = new Screen(100, 100);
		Shapes shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), Arrays.asList(4, 2));
		screen.addShape(shape1);
	}

	@Test(expected = AssertionError.class)
	public void addShape_Exception_WhenTheShapeObjectIsNull(){
		Screen screen = new Screen(100, 100);
		screen.addShape(null);
	}

	@Test(expected = AssertionError.class)
	public void addShape_Exception_WhenTheGivenPointLieOutsideTheScreen(){

		Screen screen = new Screen(100, 100);
		Shapes shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(120, 1), new ArrayList<Integer>(){{
			add(4);
			add(2);
		}});
		screen.addShape(shape1);
	}

	@Test
	public void deleteShape_HappyFlow(){

		Screen screen = new Screen(100, 100);
		Shapes shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Integer>(){{
			add(4);
			add(2);
		}});
		screen.addShape(shape1);
		screen.deleteShape(shape1);
	}

	@Test(expected = AssertionError.class)
	public void deleteShape_Exception_WhenTheShapePassedIsNull(){
		Screen screen = new Screen(100, 100);
		screen.deleteShape(null);
	}


	@Test
	public void deleteShapeType_HappyFlow(){

		Screen screen = new Screen(100, 100);
		Shapes shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Integer>(){{
			add(4);
			add(2);
		}});
		screen.addShape(shape1);

		Shapes shape2 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 3), new ArrayList<Integer>(){{
			add(5);
			add(2);
		}});
		screen.addShape(shape2);

		screen.deleteShapeType(ShapeType.RECTANGLE);
	}

	@Test(expected = AssertionError.class)
	public void deleteShapeType_Exception_WhenShapeTypeGivenIsNull(){
		Screen screen = new Screen(100, 100);
		screen.deleteShapeType(null);
	}

	@Test
	public void sortByArea_HappyFlow(){

		Screen screen = new Screen(100, 100);
		Shapes shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Integer>(){{
			add(4);
			add(2);
		}});
		screen.addShape(shape1);

		Shapes shape2 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(1, 1), new ArrayList<Integer>(){{
			add(2);
		}});
		screen.addShape(shape2);

		List<Shapes> sortedShapeByArea = screen.sortByArea();
		assertEquals(sortedShapeByArea, new ArrayList<Shapes>(){{
			add(shape2);
			add(shape1);
		}});
	}

	@Test(expected = AssertionError.class)
	public void sortByArea_Exception_WhenThereIsNoShapeOnScreen(){
		Screen screen = new Screen(100, 100);
		screen.sortByArea();
	}

	@Test
	public void sortByPerimeter_HappyFlow(){

		Screen screen = new Screen(100, 100);
		Shapes shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Integer>(){{
			add(4);
			add(2);
		}});
		screen.addShape(shape1);

		Shapes shape2 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(1, 1), new ArrayList<Integer>(){{
			add(2);
		}});
		screen.addShape(shape2);

		List<Shapes> sortedShapeByPerimeter = screen.sortByPerimeter();
		assertEquals(sortedShapeByPerimeter, new ArrayList<Shapes>(){{
			add(shape2);
			add(shape1);
		}});
	}

	@Test(expected = AssertionError.class)
	public void sortByPerimeter_Exception_WhenThereIsNoShapeOnTheScreen(){
		Screen screen = new Screen(100, 100);
		screen.sortByPerimeter();
	}

	@Test
	public void sortByOriginDistance_HappyFlow(){

		Screen screen = new Screen(100, 100);
		Shapes shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Integer>(){{
			add(4);
			add(2);
		}});
		screen.addShape(shape1);

		Shapes shape2 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(2, 1), new ArrayList<Integer>(){{
			add(2);
		}});
		screen.addShape(shape2);

		Shapes shape3 = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(0, 0), new ArrayList<Integer>(){{
			add(4);
		}});
		screen.addShape(shape3);

		List<Shapes> sortedShapeByOriginDistance = screen.sortByOriginDistance();

		assertEquals(sortedShapeByOriginDistance, new ArrayList<Shapes>(){{
			add(shape1);
			add(shape2);
			add(shape3);
		}});
	}

	@Test(expected = AssertionError.class)
	public void sortByOriginDistance_Exception_WhenThereIsNoShapeOnTheScreen(){
		Screen screen = new Screen(100, 100);
		screen.sortByOriginDistance();
	}

	@Test
	public void sortByTimestamp_HappyFlow(){

		Screen screen = new Screen(100, 100);
		Shapes shape1 = ShapeFactory.createShape(ShapeType.RECTANGLE, new Point(1, 1), new ArrayList<Integer>(){{
			add(4);
			add(2);
		}});
		screen.addShape(shape1);

		Shapes shape2 = ShapeFactory.createShape(ShapeType.SQUARE, new Point(2, 1), new ArrayList<Integer>(){{
			add(2);
		}});
		screen.addShape(shape2);

		Shapes shape3 = ShapeFactory.createShape(ShapeType.CIRCLE, new Point(0, 0), new ArrayList<Integer>(){{
			add(4);
		}});
		screen.addShape(shape3);

		List<Shapes> sortedShapeByTimestamp = screen.sortByTimestamp();
		assertEquals(sortedShapeByTimestamp, new ArrayList<Shapes>(){{
			add(shape1);
			add(shape2);
			add(shape3);
		}});
	}

	@Test(expected = AssertionError.class)
	public void sortByTimestamp_Exception_WhenThereIsNoShapeOnScreen() {
		Screen screen = new Screen(100, 100);
		screen.sortByTimestamp();
	}
}
