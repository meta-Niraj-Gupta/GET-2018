package ZooManagementSystem;

public class Lion extends Mammals{
	private static int id = 1; 

	public Lion(double weight, int age){
		super("Lion" + (id++), weight, age, "Roar", 4, false, AnimalsAvailable.LION);
	}
}
