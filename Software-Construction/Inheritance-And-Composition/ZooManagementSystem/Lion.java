package ZooManagementSystem;

/**
 * @author Niraj Gupta
 * Class to represent the Lion which is also the sub class of the class Mammals and Mammals is the sub class of the class Animal.
 *
 */
public class Lion extends Mammals{
	private static int id = 1; 

	/**
	 * Parameterized Constructor
	 * @param weight : Weight of the lion.
	 * @param age : Age of the lion.
	 */
	public Lion(double weight, int age){
		super("Lion" + (id++), weight, age, "Roar", 4, false, AnimalsAvailable.LION);
	}
}
