package Counselling;

public class ProgramsOffered{
	private String name;
	private int capacity;
	private Students[] studentQueue;
	private int seatFilled;
	
	public ProgramsOffered(String name, int capacity){
		this.name = name;
		this.capacity = capacity;
		studentQueue = new Students[capacity];
	}
	
	public void enrollStudentToProgram(Students student) throws QueueOverFlowException{
		if(isFull()){
			throw new QueueOverFlowException("OverFlow : The queue is full. Cannot add more student.");
		}else{
			studentQueue[seatFilled++] = student;
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

