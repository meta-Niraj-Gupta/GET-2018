package JobScheduler;

import java.util.Scanner;

public class MainClass {
	/**
	 * This is the main class containing main function.
	 * @param args nothing have been passed to it.
	 */
	public static void main(String[] args){
		final int NO_OF_COLUMN = 2;
		//Creating an reference to FirstComeFirstServe class
		FirstComeFirstServe fcfs = new FirstComeFirstServe();
		Scanner scan = new Scanner(System.in);	
		System.out.println("Enter the number of process: ");
		int numberOfProcess = scan.nextInt();
		//Declaring a 2-D array of type double to store arrival time and execution time of processes.
		double arrayToStoreProcessWithTime[][] = new double[numberOfProcess][NO_OF_COLUMN];
		//Taking arrival time and execution time as an input from user
		for(int i = 0; i < numberOfProcess; i++){
			System.out.println("Enter the arrival time for process " + (i+1));
			arrayToStoreProcessWithTime[i][0] = scan.nextDouble();
			System.out.println("Enter the burst time for process " + (i+1));
			arrayToStoreProcessWithTime[i][1] = scan.nextDouble();
		}
		char repeat;
		do{
			System.out.println("Menu");
			System.out.println("Press 1 to know waiting time of processes");
			System.out.println("Press 2 to know turn around time of processes");
			System.out.println("Press 3 to know completion time of processes");
			System.out.println("Press 4 to know average waiting time of processes");
			System.out.println("Press 5 to know maximum waiting time of processes");
			System.out.println("Enter your choice");
			int choice = scan.nextInt();
			switch(choice){
			case 1:
				double[] waitingTime = fcfs.findWaitingTime(arrayToStoreProcessWithTime, numberOfProcess);
				System.out.format("%10s %15s", "Process", "Waiting Time\n");
				for(int i = 0; i < numberOfProcess; i++){
					System.out.format("%8d %13f \n", i+1, waitingTime[i]);
				}
				break;
			
			case 2:
				double[] turnAroundTime = fcfs.findTurnAroundTime(arrayToStoreProcessWithTime, numberOfProcess);
				System.out.format("%10s %15s", "Process", "TurnAround Time\n");
				for(int i = 0; i < numberOfProcess; i++){
					System.out.format("%8d %13f \n", i+1, turnAroundTime[i]);
				}
				break;
			
			case 3:
				double[] completionTime = fcfs.findCompletionTime(arrayToStoreProcessWithTime, numberOfProcess);
				System.out.format("%10s %15s", "Process", "Completion Time\n");
				for(int i = 0; i < numberOfProcess; i++){
					System.out.format("%8d %13f\n", i+1, completionTime[i]);
				}
				break;
			
			case 4:
				double averageWaitingTime = fcfs.findAverageWaitingTime(arrayToStoreProcessWithTime, numberOfProcess);
				System.out.println("Average Waiting Time " + averageWaitingTime);
				break;
			
			case 5:
				double maximumWaitingTime = fcfs.findMaximumWaitingTime(arrayToStoreProcessWithTime, numberOfProcess);
				System.out.println("Maximum Waiting Time " + maximumWaitingTime);
				break;
				
			default:
				System.out.println("Please Enter a valid choice");
			}
			System.out.println("Press y to continue");
			repeat = scan.next().charAt(0);
		}while(repeat == 'y');
		scan.close();
	}
}
