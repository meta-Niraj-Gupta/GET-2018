package ZooManagementSystem;

public class Elephant extends Mammals{
	private static int id = 1; //used to maintain the unique name for elephants

	public Elephant(double weight, int age){
		super("Elephant" + (id++), weight, age, "Trumpet", 4, false, AnimalsAvailable.ELEPHANT);
	}
}
