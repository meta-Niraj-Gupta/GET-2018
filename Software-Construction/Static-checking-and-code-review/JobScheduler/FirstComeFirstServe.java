package JobScheduler;

/**
 * 
 * @author Niraj Gupta
 * This class implements the First Come First Serve scheduling algorithm.
 * This class has following behaviour:
 * 1. It can compute the waiting time of the given processes.
 * 2. It can also compute the turn around time of the user entered processes.
 * 3. It do compute the completion time of the processes.
 * 4. It also find the average waiting time of the processes.
 * 5. It find the maximum waiting time from the waiting time array which stores all the waiting time of each and every processes.
 *
 */
public class FirstComeFirstServe {
	
	/**
	 * This method calculate the waiting time of the jobs using the following formula.
	 * The waitingTime and arrivalTime of first process is 0
	 * arrivalTimeOfCurrentProcess = arrivalTimeOfPreviousProcess + executionTimeOfPreviousProcess
	 * waitingTime = arrivalTimeOfCurrentProcess - arrivalTimeofProcess
	 * If waiting time is negative then it is converted to 0 beacuse at that time the processor was idle
	 * @param copyArray is an 2-D array which stores the arrival time and execution time of the processes.
	 * @param noOfProcess is the total number of processes in 2-D array
	 * @return an 2-D array of type double containing the waiting time of the processes.
	 */
	public double[] findWaitingTime(double[][] processes, final int noOfProcess){
		double[] waitingTime = new double[noOfProcess];
		double[] arrivalTime = new double[noOfProcess];
		waitingTime[0] = 0;
		arrivalTime[0] = 0;
		for(int i = 1; i < noOfProcess; i++){
			arrivalTime[i] = arrivalTime[i-1] + processes[i-1][1];		//arrivalTime = arrivalTimeOfPreviousJob + ExecutionTimeOfPreviousJob
			waitingTime[i] = arrivalTime[i] - processes[i][0];			//waitingTime = arrivalTimeOfCurrentJob + ArrivalTimeOfCurrentJob
			if(waitingTime[i] < 0){
				waitingTime[i] = 0;
			}
		}
		return waitingTime;
	}
	
	/**
	 * This method calculate the turn around time of the jobs using the following formula.
	 * turnAroundTime = arrivalTime + waitingTime
	 * @param copyArray is an 2-D array which stores the arrival time and execution time of the processes.
	 * @param copyWaitingTime is an 2-D array which stores the waiting time of the processes.
	 * @param noOfProcess is the total number of processes in 2-D array
	 * @return 2-D array of type double containing the turn around time of all the processes.
	 */
	public double[] findTurnAroundTime(double[][] processes, final int noOfProcess){
		double[] waitingTime =  findWaitingTime(processes, noOfProcess);
		double[] turnAroundTime = new double[noOfProcess];
		for(int i = 0; i < noOfProcess; i++){
			turnAroundTime[i] = processes[i][1] + waitingTime[i];
		}
		return turnAroundTime;
	}
	
	/**
	 * This method calculates the completion time by using the formula
	 * completionTime = turnAroundTime + arrivalTime
	 * @param copyArray is an 2-D array which stores the arrival time and execution time of the processes.
	 * @param noOfProcess is the total number of processes in 2-D array
	 * @param copyTurnAroundTime is an 2-D array which stores the turn around time of the processes.
	 * @return 2-D array of type double containing the completion time of all the processes
	 */
	public double[] findCompletionTime(double[][] processes, final int noOfProcess){
		double[] completionTime = findTurnAroundTime(processes, noOfProcess);
		double[] completionTimeArray = new double[noOfProcess];
		for(int i = 0; i < noOfProcess; i++){
			completionTimeArray[i] = completionTime[i] + processes[i][0];
		}
		return completionTimeArray;
	}
	
	/**
	 * This method computes the average waiting time by using the formula
	 * averageWaitingTime = waitingTime[0 .. numberOfProcess] / numberOfProcess
	 * @param copyWaitingTime is an 2-D array which stores the waiting time of the processes.
	 * @param noOfProcess is the total number of processes in 2-D array
	 * @return a double that is the averageWaiting time. 
	 */
	public double findAverageWaitingTime(double[][] processes, final int noOfProcess){
		double[] waitingTime = findWaitingTime(processes, noOfProcess);
		double totalWaitingTime = 0.0;
		for(int i = 0; i < noOfProcess; i++){
			totalWaitingTime += waitingTime[i];
		}
		return totalWaitingTime/noOfProcess;
	}
	
	/**
	 * This method finds the process having maximum waiting time.
	 * It uses linear search to do so.
	 * @param copyWaitingTime is an 2-D array which stores the waiting time of the processes.
	 * @return double that is the maximumWaitingTime of the process
	 */
	public double findMaximumWaitingTime(double[][] processes, final int noOfProcess){
		double[] waitingTime = findWaitingTime(processes, noOfProcess);
		double maximumWatingTime = waitingTime[0];
		for(int i = 1; i < waitingTime.length; i++){
			if(waitingTime[i] > maximumWatingTime){
				maximumWatingTime = waitingTime[i];
			}
		}
		return maximumWatingTime;
	}
	
}
