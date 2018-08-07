package ZooManagementSystem;

/**
 * @author Niraj Gupta
 * Class to represent the Peacock which is also the sub class of the class Bird and Bird is the sub class of the class Animal.
 *
 */
public class Peacock extends Birds{
	static int id = 1; 

	/**
	 * Parameterized Constructor
	 * @param weight : Weight of the parrot. 
	 * @param age : Age of the parrot.
	 * @param flyHeight : The maximum height upto which the parrot can fly.
	 */
	public Peacock(double weight, int age, double flyHeight){
		super("Peacock" + (id++), weight, age, "scream", 2, true, flyHeight, AnimalsAvailable.PEACOCK);
	}
}
