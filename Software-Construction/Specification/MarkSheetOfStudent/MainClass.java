package MarkSheetOfStudent;

import java.util.Scanner;

import UsingRecursionToCalculateLcmAndHcf.InvalidInputException;

/**
 * @author Niraj Gupta
 * This class is the main having main function and is used to check if the methods of the class MarkSheet are working properly or not.
 *
 */
public class MainClass {
	public static void main(String[] args) throws InvalidInputException{
		Scanner scan = new Scanner(System.in);
		MarkSheet marksheet = new MarkSheet();
		System.out.println("Enter the total number of student in a class");
		int totalNumberOfStudent = scan.nextInt();
		double[] studentGrades = new double[totalNumberOfStudent];
		for(int i = 0; i < totalNumberOfStudent; i++){
			System.out.println("Enter the grade of student " + (i+1));
			studentGrades[i] = scan.nextDouble();
		}
		char repeat;
		do{
			System.out.println("Menu");
			System.out.println("Press 1 to compute the average grades");
			System.out.println("Press 2 to find the maximum grade obtained");
			System.out.println("Press 3 to find the minimum grade obtained");
			System.out.println("Press 4 to find the percentage of the student passed");
			System.out.println("Enter your choice");
			int choice = scan.nextInt();
			switch(choice){
			
			case 1:
				System.out.println("The average grade of the class is " 
									+ Math.round(marksheet.calculateAverage(studentGrades, totalNumberOfStudent) * 100) / 100);
				break;
			
			case 2:
				System.out.println("The maximum grade of the class is " 
									+ Math.round(marksheet.getMaximumGrade(studentGrades, totalNumberOfStudent) * 100) / 100);
				break;
			
			case 3:
				System.out.println("The minimum grade of the class is " 
									+ Math.round(marksheet.getMinimumGrade(studentGrades, totalNumberOfStudent) * 100) / 100);
				break;
			
			case 4:
				System.out.println("The percentage of passed student is " 
										+ Math.round(marksheet.calculateTotalPercentageOfPassedStudents(studentGrades, totalNumberOfStudent) * 100) / 100);
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
