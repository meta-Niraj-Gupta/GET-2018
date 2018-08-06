package ZooManagementSystem;

public class Snake extends Reptiles{
	static int id = 1;

	public Snake(double weight, int age){
		super("Snake" + (id++), weight, age, "Hiss", 0, true, "cold", AnimalsAvailable.SNAKE);
	}
}
