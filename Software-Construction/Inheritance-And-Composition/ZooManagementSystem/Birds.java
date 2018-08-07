package ZooManagementSystem;

/**
 * @author Niraj Gupta
 * Class to represent the Bird which is also the sub class of the Animal class.
 *
 */
public class Birds extends Animals{
	private final boolean canFly;
	private double flyHeight;

	/**
	 * Parameterized Constructor
	 * @param name : The name of the bird.
	 * @param weight : The weight of the bird.
	 * @param age : The age of the bird.
	 * @param sound : The sound produced by the bird.
	 * @param numberOfLegs : The number of legs the bird has.
	 * @param canFly : Whether the bird can fly or not.
	 * @param flyHeight : The maximum height the bird can fly upto.
	 * @param animalType : The type to which the bird belongs to.
	 */
	public Birds(String name, double weight, int age, String sound,
			int numberOfLegs, boolean canFly, double flyHeight, AnimalsAvailable animalType){

		super(name, weight, age, sound, numberOfLegs, AnimalTypes.BIRD, animalType);

		this.canFly = canFly;
		this.flyHeight = flyHeight;
	}	

	/**
	 * @return : The maximum height the bird can fly to.
	 */
	public double getflyHeight(){
		return flyHeight;
	}

	/**
	 * Method to set the height upto which the bird can fly.
	 * @param flyHeight : The height upto which the bird can fly.
	 */
	public void setflyHeight(double flyHeight){
		this.flyHeight = flyHeight;
	}

	/**
	 * @return : True if the bird can fly, false otherwise.
	 */
	public boolean canFly(){
		return canFly;
	}

}
