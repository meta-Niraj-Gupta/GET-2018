package ZooManagementSystem;

/**
 * @author Niraj Gupta
 * Class to represent the Elephant which is also the sub class of the class Mammals and Mammals is the sub class of the class Animal.
 *
 */
public class Elephant extends Mammals{
	private static int id = 1; //used to maintain the unique name for elephants

	/**
	 * Parameterized Constructor
	 * @param weight : Weight of the Crocodile.
	 * @param age : Age of the Crocodile.
	 */
	public Elephant(double weight, int age){
		super("Elephant" + (id++), weight, age, "Trumpet", 4, false, AnimalsAvailable.ELEPHANT);
	}
}
