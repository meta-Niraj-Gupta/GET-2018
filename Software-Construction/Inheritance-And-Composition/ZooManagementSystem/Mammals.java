package ZooManagementSystem;

public class Mammals extends Animals{
	private final boolean hasFurs;

	public Mammals(String name, double weight, int age, String sound,
			int numberOfLegs, boolean hasFurs, AnimalsAvailable animalType){

		super(name, weight, age, sound, numberOfLegs, AnimalTypes.MAMMAL, animalType);

		this.hasFurs = hasFurs;
	}

	public boolean hasFurs(){
		return hasFurs;
	}
}
