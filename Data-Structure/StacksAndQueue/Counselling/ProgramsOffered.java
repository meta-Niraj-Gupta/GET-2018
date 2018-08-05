package Counselling;

import QueueDataStructure.Queue;
import QueueDataStructure.QueueUsingArray;

public class ProgramsOffered{
	private String name;
	private int capacity;
	private int seatFilled;
	private Queue<Students> studentQueue;
	
	public ProgramsOffered(String name, int capacity){
		this.name = name;
		this.capacity = capacity;
		studentQueue = new QueueUsingArray<Students>(this.capacity);
	}
	
	public void enrollStudentToProgram(Students student){
		if(isFull()){
			throw new QueueOverFlowException("OverFlow : The queue is full. Cannot add more student.");
		}else{
			studentQueue.enqueue(student);
			student.setProgramAllotted(name);
		}
	}
	
	public boolean isFull(){
		return seatFilled == capacity;
	}
	
	public String getName(){
		return name;
	}
	
	public int getCapacity(){
		return capacity;
	}
}

