package ZooManagementSystem;

/**
 * @author Niraj Gupta
 * Class to represent the Reptiles which is also the sub class of the Animal class.
 *
 */
public class Reptiles extends Animals{
	private final boolean isPoisonous;
	private final String bloodType;

	/**
	 * Parameterized Constructor
	 * @param name : The name of the reptile.
	 * @param weight : The weight of the reptile.
	 * @param age : The age of the reptile.
	 * @param sound : The sound produced by the reptile.
	 * @param numberOfLegs : The number of legs the reptile has.
	 * @param isPoisonous : Whether the reptile is poisonous or not.
	 * @param bloodType : The type of the blood.
	 * @param animlType : The type of the animal which is reptile.
	 */
	public Reptiles(String name, double weight, int age, String sound,
			int numberOfLegs, boolean isPoisonous, String bloodType, AnimalsAvailable animlType){

		super(name, weight, age, sound, numberOfLegs, AnimalTypes.REPTILE, animlType);

		this.isPoisonous = isPoisonous;
		this.bloodType = bloodType;
	}

	/**
	 * @return : True if the reptile is poisonous, flase otherwise.
	 */
	public boolean isPoisonous(){
		return isPoisonous;
	}

	/**
	 * @return : The blood type of the reptile.
	 */
	public String getBloodType(){
		return bloodType;
	}
}
