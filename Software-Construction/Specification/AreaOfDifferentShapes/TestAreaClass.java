package AreaOfDifferentShapes;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import UsingRecursionToCalculateLcmAndHcf.InvalidInputException;


/**
 * This is the Junit test class for Area class. 
 * It test all their operations and exceptions.
 * 
 * @author Niraj Gupta
 *
 */
@RunWith(Parameterized.class)
public class TestAreaClass{

	private double width;
	private double height;
	private double areaOfCircle;
	private double areaOfTriangle;
	private double areaOfSquare;
	private double areaOfRectangle;
	private Area area = new Area();

	/**
	 * This Constructor will be used by the Parameterized.class to run the test cases.
	 * It initializes the inputs and expected outputs.
	 * 
	 * @param width
	 * @param height
	 * @param areaOfCircle
	 * @param areaOfTriangle
	 * @param areaOfSquare
	 * @param areaOfRectangle
	 */
	public TestAreaClass(double width, double height, double areaOfCircle, double areaOfTriangle, double areaOfSquare,
			double areaOfRectangle) {
		this.width = width;
		this.height = height;
		this.areaOfCircle = areaOfCircle;
		this.areaOfTriangle = areaOfTriangle;
		this.areaOfSquare = areaOfSquare;
		this.areaOfRectangle = areaOfRectangle;
	}

	/**
	 * Add the test cases here, just extend the current array with your sequences
	 * 
	 * @return Collections of inputs which will be used by Parameterized.class
	 */
	@Parameterized.Parameters
	public static Collection testStrings(){
		return Arrays.asList(
				new Object[][]{
					//width,height,areaOfCircle,areaOfTriangle,areaOfSquare,areaOfRectangle
					
					//positive test cases
					{34., 45., 3631.68, 765.0, 1156.0, 1530.0},
					{3., 45., 28.27, 67.5, 9.0, 135.0},
					{34., 4., 3631.68, 68.0, 1156.0, 136.0},
					{34., 0., 3631.68, 0.0, 1156.0, 0.0},
					
					//negative test cases
					//{0., 0., 3631.68, 0.0, 1156.0, 0.0}
//					{34., 0., 3631.68, 0.0, 1156.0, 0.0}
//					{34., 0., 3631.68, 0.0, 1156.0, 0.0}
//					{34., 0., 3631.68, 0.0, 1156.0, 0.0}
				}
			);
	}

	/**
	 * This function will be used by Parametrized.class, once object is 
	 * created with the given parameters, this function is ran to test 
	 * the functionalities.
	 * @throws InvalidInputException 
	 */
	@Test
	public void positiveTestCases(){
		try {
			assertTrue(Math.abs(area.calculateAreaOfCircle(width) - areaOfCircle) < 0.01);
		}catch(InvalidInputException e3){
			e3.printStackTrace();
		}
		try{
			assertTrue(Math.abs(area.calculateAreaOfRectangle(width, height) - areaOfRectangle) < 0.01);
		}catch (InvalidInputException e2){
			e2.printStackTrace();
		}
		try{
			assertTrue(Math.abs(area.calculateAreaOfSquare(width) - areaOfSquare) < 0.01);
		}catch(InvalidInputException e1){
			e1.printStackTrace();
		}
		try{
			assertTrue(Math.abs(area.calculateAreaOfTriangle(width, height) - areaOfTriangle) < 0.01);
		}catch(InvalidInputException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Used to print test details.
	 */
	@Override
	public String toString() {
		return "AreaTest [width=" + width + ", height=" + height + ", areaOfCircle=" + areaOfCircle
				+ ", areaOfTriangle=" + areaOfTriangle + ", areaOfSquare=" + areaOfSquare + ", areaOfRectangle="
				+ areaOfRectangle + "]";
	}
}