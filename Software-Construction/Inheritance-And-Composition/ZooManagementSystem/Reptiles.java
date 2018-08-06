package ZooManagementSystem;

public class Reptiles extends Animals{
	private final boolean isPoisonous;
	private final String bloodType;

	public Reptiles(String name, double weight, int age, String sound,
			int numberOfLegs, boolean isPoisonous, String bloodType, AnimalsAvailable animlType){

		super(name, weight, age, sound, numberOfLegs, AnimalTypes.REPTILE, animlType);

		this.isPoisonous = isPoisonous;
		this.bloodType = bloodType;
	}

	public boolean isPoisonous(){
		return isPoisonous;
	}

	public String getBloodType(){
		return bloodType;
	}
}
