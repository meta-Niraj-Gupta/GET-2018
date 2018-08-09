package ZooManagementSystem;

/**
 * @author Niraj Gupta
 * Class to represent the Mammals which is also the sub class of the Animal class.
 *
 */
public class Mammals extends Animals{
	private final boolean hasFurs;

	/**
	 * Parameterized Constructor.
	 * @param name : The name of the mammal.
	 * @param weight : The weight of the mammal.
	 * @param age : The age of the mammal.
	 * @param sound : The sound produced by the mammal.
	 * @param numberOfLegs : The number of legs the mammal has.
	 * @param hasFurs : Whether the mammal has fur or not.
	 * @param animalType : The type of the animal to which it belongs.
	 */
	public Mammals(String name, double weight, int age, String sound,
			int numberOfLegs, boolean hasFurs, AnimalsAvailable animalType){

		super(name, weight, age, sound, numberOfLegs, AnimalTypes.MAMMAL, animalType);

		this.hasFurs = hasFurs;
	}

	/**
	 * @return : True if the Mammal has fur, false otherwise.
	 */
	public boolean hasFurs(){
		return hasFurs;
	}
}
