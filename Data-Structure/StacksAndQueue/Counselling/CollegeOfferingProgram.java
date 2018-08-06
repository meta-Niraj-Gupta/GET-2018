package Counselling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import QueueDataStructure.QueueUsingLinkList;

public class CollegeOfferingProgram{
	private QueueUsingLinkList<Students> programQueue;
	private Map<String, ProgramsOffered> programs;
	
	public CollegeOfferingProgram(List<ProgramsOffered> programs){
		this.programs = new HashMap<>();
		// Adds all programs to the map
		for (ProgramsOffered program: programs){
			if(this.programs.containsKey(program.getName()))
				throw new IllegalArgumentException("Program list has programs with same name");
			this.programs.put(program.getName(), program);
		}
		programQueue = new QueueUsingLinkList<Students>();
	}
	
	public List<Students> counselling() throws QueueOverFlowException{
		List<Students> driveResults = new ArrayList<Students>();
		// Entertain every student one by one based on rank
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
	
	public void enqueueStudent(Students student){
		programQueue.enqueue(student);
	}
}
