package ZooManagementSystem;

/**
 * @author Niraj Gupta
 * Class to represent the Crocodile which is also the sub class of the class Reptiles and Reptiles is the sub class of the class Animal.
 *
 */
public class Crocodile extends Reptiles{
	static int id = 1; 

	/**
	 * Parameterized Constructor
	 * @param weight : Weigth of the crocodile
	 * @param age : The age of the Crocodile
	 */
	public Crocodile(double weight, int age){
		super("Crocodile" + (id++), weight, age, "Roar", 4, false, "warm", AnimalsAvailable.CROCODILE);
	}
}
