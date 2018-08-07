package ZooManagementSystem;

/**
 * @author Niraj Gupta
 * Class to represent the Snake which is also the sub class of the class Reptiles and Reptiles is the sub class of the class Animal.
 *
 */
public class Snake extends Reptiles{
	static int id = 1;

	/**
	 * Parameterized Constructor
	 * @param weight : Weigth of the snake.
	 * @param age : The age of the snake.
	 */
	public Snake(double weight, int age){
		super("Snake" + (id++), weight, age, "Hiss", 0, true, "cold", AnimalsAvailable.SNAKE);
	}
}
