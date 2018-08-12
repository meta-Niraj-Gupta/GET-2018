package ViratProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Niraj Gupta
 * Class to find the bolwing order such that the runs scored by virat is minimum.
 */
public class MinimizingViratScore {
	Map<String, Integer> bowlers;
	private int noOfBallsViratPlay;

	/**
	 * Parameterized Constructor
	 * @param noOfBallsViratPlay : The number of balls that virat can play.
	 * @param bowlers : The bowlers with the number of balls remaining to be bowled.
	 * @throws InsufficientBallsLeftException : When the number of ball left is less than the number of balls that
	 * 											virat can play
	 */
	public MinimizingViratScore(int noOfBallsViratPlay, Map<String, Integer> bowlers) throws InsufficientBallsLeftException{    
		if(sum(bowlers) >= noOfBallsViratPlay){
			this.noOfBallsViratPlay = noOfBallsViratPlay; 
			this.bowlers = bowlers;
		}else{
			throw new InsufficientBallsLeftException("Insufficient balls left!!");
		}
	}


	/**
	 * Method to calculates the bowling order such that the runs scored by Virat is minimum.
	 * @return bowlingOrder : The list of bowling order.
	 */
	public List<String> bowlingOrder(){
		List<String> bowlingOrder = new ArrayList<>();
		for(int i = 0; i < noOfBallsViratPlay; i++){
			String bowler = findBowler();
			bowlingOrder.add(bowler);
			bowlers.put(bowler, bowlers.get(bowler) - 1);
		}
		return bowlingOrder;
	}


	/**
	 * Method to find the bowler with the maximum number of balls left to bowl.
	 * @return : The bowler having the maximum number of balls left to ball.
	 */
	private String findBowler(){
		int maxBalls = 0;
		String bowler = null;
		for(String bowlerName: bowlers.keySet()){
			int balls = bowlers.get(bowlerName);
			if(maxBalls < balls){
				maxBalls = balls;
				bowler = bowlerName;
			}
		}
		return bowler;
	}


	/**
	 * Method to add the total number of balls of all the bowlers
	 * @param bowlers :The bowlers having the remaining balls to bowl.
	 * @return sum : The sum of remaining balls.
	 */
	private int sum(Map<String, Integer> bowlers){
		int sum = 0;
		for(String bowler: bowlers.keySet()){
			sum += bowlers.get(bowler);
		}
		return sum;
	}
}
