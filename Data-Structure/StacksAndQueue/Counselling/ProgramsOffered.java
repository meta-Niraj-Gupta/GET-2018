package Counselling;

/**
 * @author Niraj Gupta
 * Class to set the programs offered by the college. Each program has a name and the maximum capacity.
 */
public class ProgramsOffered{
	private String name;
	private int capacity;
	private Students[] studentQueue;
	private int seatFilled;
	
	/**
	 * Parameterized Constructor
	 * @param name : The name of the program offered by the college.
	 * @param capacity : The total number of students which can be processed.
	 */
	public ProgramsOffered(String name, int capacity){
		this.name = name;
		this.capacity = capacity;
		studentQueue = new Students[capacity];
	}
	
	/**
	 * Method to enroll student to a particular program.
	 * @param student : The student which is to be allocated to the program.
	 * @throws QueueOverFlowException : While adding student to the queue if the queue becomes full then this exception is thrown.
	 */
	public void enrollStudentToProgram(Students student) throws QueueOverFlowException{
		if(isFull()){
			throw new QueueOverFlowException("OverFlow : The queue is full. Cannot add more student.");
		}else{
			studentQueue[seatFilled++] = student;
			student.setProgramAllotted(name);
		}
	}
	
	/**
	 * @return : True if the seat filled is equal to the capcity of the program, false otherwise.
	 */
	public boolean isFull(){
		return seatFilled == capacity;
	}
	
	/**
	 * @return : The name of the program.
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * @return : The maximum capacity of the program.
	 */
	public int getCapacity(){
		return capacity;
	}
}

