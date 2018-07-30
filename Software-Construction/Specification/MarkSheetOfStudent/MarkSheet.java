package MarkSheetOfStudent;

import UsingRecursionToCalculateLcmAndHcf.InvalidInputException;

/**
 * @author Niraj Gupta	
 * Class to make mark sheet of students.
 */
public class MarkSheet {
	
	/**
	 * Method to calculates the average grades of all the students.
	 * This method requires the numberOfStudent > zero
	 * @param grades : array of type double to stores the grade of the students and is of type double.
	 * @param numberOfStudent : store the total count of students and is of type int.
	 * @return : the average grade of the students of type double.
	 * @throws InvalidInputException 
	 */
	public double calculateAverage(double[] grades, int numberOfStudent) throws InvalidInputException{
		double output = 0.0;
		if(numberOfStudent < 0){
			throw new InvalidInputException("Invalid Input : The number of student can never be zero. Enter valid input.");
		}else{
			try{
				double totalGrades = 0.0;
				for(int i = 0; i < numberOfStudent; i++){
					totalGrades += grades[i];
				}
				output = totalGrades/numberOfStudent;
			}catch(ArithmeticException exception){
				System.out.println(exception.getMessage());
			}
		}
		return output;
	}
	
	/**
	 * Method to find the maximum grade from the array storing the grades of the student by using linear search.
	 * @param grades : array of type double to stores the grade of the students and is of type double.
	 * @param numberOfStudent : store the total count of students and is of type int.
	 * @return : The maximum grade present in the array of type double.
	 * @throws InvalidInputException 
	 */
	public double getMaximumGrade(double[] grades, int numberOfStudent) throws InvalidInputException{
		double maximumGradeOfStudent = grades[0];
		if(numberOfStudent < 0){
			throw new InvalidInputException("Invalid Input : The number of student can never be zero. Enter valid input.");
		}else{
			for(int i = 1; i < numberOfStudent; i++){
				if(grades[i] > maximumGradeOfStudent){
					maximumGradeOfStudent = grades[i];
				}
			}
		}
		return maximumGradeOfStudent;
	}
	
	/**
	 * Method to finds the minimum grade from the array of grades.
	 * @param grades : array of type double to stores the grade of the students and is of type double.
	 * @param numberOfStudent : store the total count of students and is of type int.
	 * @return : The minimum grade present in the array of type double.
	 * @throws InvalidInputException 
	 */
	public double getMinimumGrade(double[] grades, int numberOfStudent) throws InvalidInputException{
		double minimumGradeOfTheStudent = grades[0];
		if(numberOfStudent < 0){
			throw new InvalidInputException("Invalid Input : The number of student can never be zero. Enter valid input.");
		}else{
			for(int i = 1; i < numberOfStudent; i++){
				if(grades[i] < minimumGradeOfTheStudent){
					minimumGradeOfTheStudent = grades[i];
				}
			}
		}
		return minimumGradeOfTheStudent;
	}
	
	/**
	 * Method to computes the total percentage of passed student
	 * @param grades : array of type double to stores the grade of the students and is of type double.
	 * @param numberOfStudent : store the total count of students and is of type int.
	 * @return : The total percentage of student who have successfully cleared the exam and is of type double.
	 * @throws InvalidInputException 
	 */
	public double calculateTotalPercentageOfPassedStudents(double[] grades, int numberOfStudent) throws InvalidInputException{
		double output = 0.0;
		int totalPassedStudents = 0;
		if(numberOfStudent < 0){
			throw new InvalidInputException("Invalid Input : The number of student can never be zero. Enter valid input.");
		}else{
			try{
				for(int i = 0; i < numberOfStudent; i++){
					if(grades[i] >= 40.0){
						totalPassedStudents++;
					}
				}
				output = (totalPassedStudents / numberOfStudent) * 100;
			}catch(ArithmeticException exception){
				System.out.println(exception.getMessage());
			}
		}
		return output;
	}
}
