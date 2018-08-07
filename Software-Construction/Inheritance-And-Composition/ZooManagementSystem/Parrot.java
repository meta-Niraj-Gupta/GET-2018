package ZooManagementSystem;

/**
 * @author Niraj Gupta
 * Class to represent the Parrot which is also the sub class of the class Bird and Bird is the sub class of the class Animal.
 *
 */
public class Parrot extends Birds{
	static int id = 1; 

	/**
	 * Parameterized Constructor
	 * @param weight : Weight of the parrot. 
	 * @param age : Age of the parrot.
	 * @param flyHeight : The maximum height upto which the parrot can fly.
	 */
	public Parrot(double weight, int age, double flyHeight){
		super("Parrot" + (id++), weight, age, "squawk", 2, true, flyHeight, AnimalsAvailable.PARROT);
	}
}
