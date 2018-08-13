package PriorityQueue;

/**
 * @author Niraj Gupta
 * Class to represent the job which is to be added in the queue.
 */
public class Job{
	final int value;
	final int priority;

	/**
	 * Parameterized Constructor.
	 * @param value : The task stored by the job which is to be processed.
	 * @param priority : The priority of the job.
	 */
	public Job(int value, int priority){

		this.value = value;
		this.priority = priority;
	}

	public int getValue(){
		return value;
	}

	public int getPriority(){
		return priority;
	}
}
