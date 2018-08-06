package ZooManagementSystem;

public class Peacock extends Birds{
	static int id = 1; 

	public Peacock(double weight, int age, double wingsSpan){
		super("Peacock" + (id++), weight, age, "scream", 2, true, wingsSpan, AnimalsAvailable.PEACOCK);
	}
}
