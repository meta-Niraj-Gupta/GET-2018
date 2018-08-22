package Counselling;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Niraj Gupta
 * Class to set the student and their preferences.
 *
 */
public class Students{
	private String studentName;
	private List<String> preferences = new ArrayList<String>();
	private String programAllotted;
	
	/**
	 * Parameterized Constructor
	 * @param studentName : The name of the student.
	 * @param preferences : The list of preferences stored in descending order.
	 */
	public Students(String studentName, List<String> preferences){
		this.studentName = studentName;
		this.preferences = preferences;
	}
	
	/**
	 * @return : The name of the student.
	 */
	public String getName(){
		return studentName;
	}
	
	/**
	 * @return : The list of preferences.
	 */
	public List<String> getPreferences(){
		return preferences;
	}
	
	/**
	 * Method to set the program allotted to the student.
	 * @param programAllotted : The name of the program allotted to the student.
	 */
	public void setProgramAllotted(String programAllotted){
		this.programAllotted = programAllotted;
	}
	
	/**
	 * @return : The name of the program allotted to the student.
	 */
	public String getProgramAllotted(){
		return programAllotted;
	}
}
