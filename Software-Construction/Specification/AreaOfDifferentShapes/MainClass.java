package AreaOfDifferentShapes;

import java.util.Scanner;

import UsingRecursionToCalculateLcmAndHcf.InvalidInputException;

/**
 * 
 * @author Niraj Gupta
 * Main class containing the main function and is used to check if the Area class is working properly or not.
 *
 */
public class MainClass {
	public static void main(String[] args) throws InvalidInputException{
		Scanner scan = new Scanner(System.in);
		Area area = new Area();
		char repeat;
		do{
			System.out.println("Menu");
			System.out.println("Press 1 to compute the area of triangle");
			System.out.println("Press 2 to compute the area of rectangle");
			System.out.println("Press 3 to compute the area of square");
			System.out.println("Press 4 to compute the area of circle");
			System.out.println("Enter your choice");
			int choice = scan.nextInt();
			switch(choice){
			
			case 1:
				System.out.println("Enter the width/base of the triangle");
				double base = scan.nextDouble();
				System.out.println("Enter the height of the triangle");
				double height = scan.nextDouble();
				System.out.println("The area of the triangle is " + area.calculateAreaOfTriangle(base, height));
				break;
			
			case 2:
				System.out.println("Enter the width of the rectangle");
				double width = scan.nextDouble();
				System.out.println("Enter the length of the rectangle");
				double length = scan.nextDouble();
				System.out.println("The area of the rectangle is " + area.calculateAreaOfRectangle(width, length));
				break;
			
			case 3:
				System.out.println("Enter the side of the square");
				double side = scan.nextDouble();
				System.out.println("The area of the square is " + area.calculateAreaOfSquare(side));
				break;
			
			case 4:
				System.out.println("Enter the radius of the circle");
				double radius = scan.nextDouble();
				System.out.println("The area of the circle is " + area.calculateAreaOfCircle(radius));
				break;
			
			default:
				System.out.println("Enter a valid choice");
			}
			System.out.println("Press y to continue");
			repeat = scan.next().charAt(0);
		}while(repeat == 'y');
		scan.close();
	}
}
