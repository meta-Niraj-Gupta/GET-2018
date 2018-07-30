package AreaOfDifferentShapes;

import UsingRecursionToCalculateLcmAndHcf.InvalidInputException;

/**
 * 
 * @author Niraj Gupta
 * Class to compute the area of different shapes for example triangle, rectangle, square and circle.
 */
public class Area {
	
	/**
	 * Method to computes the area of the triangle
	 * This function requires width and height to be more than 0 i.e. width, height > 0
	 * @param width	: stores the base of the triangle and is of type double
	 * @param height : stores the height of the triangle and is of type double
	 * @return : the area of the triangle
	 * @throws InvalidInputException 
	 */
	public double calculateAreaOfTriangle(double width, double height) throws InvalidInputException{
		double areaOfTriangle = 0.0;
		if(width < 0 || height < 0){
			throw new InvalidInputException("Invalid Input : The input can not be negative. Enter positive value");
		}else{
			try{
				areaOfTriangle = width * height * 0.5; // areaOfTriangle = 0.5 * base * height
			}catch(ArithmeticException exception){
				System.out.println(exception.getMessage());
			}
		}
		return areaOfTriangle; 
	}
	
	/**
	 * Method to computes the area of the rectangle
	 * This function requires length and width to be more than 0 i.e. width, length > 0
	 * @param width : stores the breadth of the rectangle and is of type double
	 * @param length : stores the length of the rectangle and is of type double
	 * @return : the area of the rectangle
	 * @throws InvalidInputException 
	 */
	public double calculateAreaOfRectangle(double width, double length) throws InvalidInputException{
		double areaOfRectangle = 0.0;
		if(width < 0 || length < 0){
			throw new InvalidInputException("Invalid Input : The input can not be negative. Enter positive value");
		}else{
			try{
				areaOfRectangle = width*length;	// area of rectangle = length * breadth/width
			}catch (ArithmeticException exception) {
				System.out.println(exception.getMessage());
			}
		}
		return areaOfRectangle;	
	}
	
	/**
	 * Method to computes the area of the square
	 * This function requires side to be more than 0 i.e. side > 0
	 * @param side : stores the length of the side of the square and is of type double
	 * @return : the area of the square
	 * @throws InvalidInputException 
	 */
	public double calculateAreaOfSquare(double side) throws InvalidInputException{
		double areaOfSquare = 0.0;
		if(side < 0){
			throw new InvalidInputException("Invalid Input : The side of square can not be negative. Enter positive number");
		}else{
			try{
				areaOfSquare = side*side;	// area of square = side * side
			}catch (ArithmeticException exception) {
				System.out.println(exception.getMessage());
			}
		}
		return areaOfSquare;		 
	}
	
	/**
	 * Method to computes the area of the circle
	 * This function requires side to be more than 0 i.e. side > 0
	 * @param radius : stores the radius of the circle and is of type double
	 * @return : the area of the circle
	 * @throws InvalidInputException 
	 */
	public double calculateAreaOfCircle(double radius) throws InvalidInputException{
		double areaOfCircle = 0.0;
		if(radius < 0){
			throw new InvalidInputException("Invalid Input : The side of square can not be negative. Enter positive number");
		}else{
			try{
				areaOfCircle = Math.PI*radius*radius;	// area of circle = 3.14 * radius * radius
			}catch (ArithmeticException exception) {
				System.out.println(exception.getMessage());
			}
		}
		return areaOfCircle;	
	}
}
