package ZooManagementSystem;

public class Crocodile extends Reptiles{
	static int id = 1; 

	public Crocodile(double weight, int age){
		super("Crocodile" + (id++), weight, age, "Roar", 4, false, "warm", AnimalsAvailable.CROCODILE);
	}
}
