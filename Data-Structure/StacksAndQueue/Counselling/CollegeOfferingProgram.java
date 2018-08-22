package Counselling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import QueueDataStructure.QueueUsingLinkList;

/**
 * @author Niraj Gupta
 * Class to allocate students to the program offered by the college.
 *
 */
public class CollegeOfferingProgram{
	private QueueUsingLinkList<Students> programQueue;
	private static Map<String, ProgramsOffered> programs;
	
	/**
	 * Parameterized Constructor 
	 * @param programs : List of programs which are offered by the college with their maximum capacity.
	 */
	public CollegeOfferingProgram(List<ProgramsOffered> program){
		programs = new HashMap<>();
		// Adds all programs to the map
		for (ProgramsOffered pro: program){
			if(programs.containsKey(pro.getName())){
				throw new IllegalArgumentException("Program list has programs with same name");
			}
			programs.put(pro.getName(), pro);
		}
		programQueue = new QueueUsingLinkList<Students>();
	}
	
	/**
	 * Method to perform counselling for student based on their preferences.
	 * @return : The List of Students and the name of program to which each student is allotted.
	 * @throws QueueOverFlowException : While adding student if the queue become full then QueueOverFlowWException is thrown.
	 */
	public List<Students> counselling() throws QueueOverFlowException{
		List<Students> driveResults = new ArrayList<Students>();
		// Entertain every student one by one based on preferences
		while(!programQueue.isEmpty()){
			try{
				// Check availability of every program in students preference list
				for(String programName: programQueue.getFront().getPreferences()){
					// If a program can has vacancy, enroll the student and break
					if(!programs.get(programName).isFull()){
						programs.get(programName).enrollStudentToProgram(programQueue.getFront());
						break;
					}
				}
				driveResults.add(programQueue.dequeue());
			}catch(IllegalStateException e){
				break;
			}
		}
		return driveResults;
	}
	
	/**
	 * Method to add student to the queue.
	 * @param student : The student which is to be added to the queue.
	 */
	public void enqueueStudent(Students student){
		programQueue.enqueue(student);
	}
}
