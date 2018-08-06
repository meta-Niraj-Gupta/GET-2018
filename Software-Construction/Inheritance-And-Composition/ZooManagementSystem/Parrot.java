package ZooManagementSystem;

public class Parrot extends Birds{
	static int id = 1; 

	public Parrot(double weight, int age, double flyHeight){
		super("Parrot" + (id++), weight, age, "squawk", 2, true, flyHeight, AnimalsAvailable.PARROT);
	}
}
