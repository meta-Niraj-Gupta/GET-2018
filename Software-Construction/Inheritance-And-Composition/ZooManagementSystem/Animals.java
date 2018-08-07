package ZooManagementSystem;

/**
 * @author Niraj Gupta
 * Class to represent the Animal which is also the super class.
 *
 */
public class Animals{
	private final String name;
	private double weight;
	private int age;
	private final String sound;
	private final int numberOfLegs;
	private final AnimalTypes category;
	private final AnimalsAvailable animalType;


	/**
	 * Parameterized Constructor
	 * @param name : The name of the Animal
	 * @param weight : The weight of the Animal.
	 * @param age : The age of the Animal.
	 * @param sound : The sound produced by the Animal.
	 * @param numberOfLegs : The number of legs the Animal has.
	 * @param category : The type of the animal i.e. Mammal, reptile or bird.
	 * @param animalType : The sub type of the animal type like Mammal contains Lion etc.
	 */
	public Animals(String name, double weight, int age, String sound, int numberOfLegs, AnimalTypes category, AnimalsAvailable animalType){
		this.name = name;
		this.weight = weight;
		this.age = age;
		this.sound = sound;
		this.numberOfLegs = numberOfLegs;
		this.category = category;
		this.animalType = animalType;
	}

	/**
	 * @return : The weight of the animal.
	 */
	public double getWeight(){
		return weight;
	}

	/**
	 * Method to set the weight of the animal.
	 * @param weight : The weigth of the animal.
	 */
	public void setWeight(double weight){
		this.weight = weight;
	}

	/**
	 * @return : The age of the animal.
	 */
	public int getAge(){
		return age;
	}

	/**
	 * Method to set the age of the animal.
	 * @param weight : The age of the animal.
	 */
	public void setAge(int age){
		this.age = age;
	}

	/**
	 * @return : The name of the animal.
	 */
	public String getName(){
		return name;
	}

	/**
	 * @return : The sound produced by the animal.
	 */
	public String getSound(){
		return sound;
	}

	/**
	 * @return : The number of legs the animal has.
	 * 	 
	 */
	public int getNumberOfLegs(){
		return numberOfLegs;
	}

	/**
	 * @return : The type of the animal.
	 */
	public AnimalsAvailable getAnimalType(){
		return animalType;
	}

	/**
	 * @return : The sub-Type of the animal like lion is a mammal which is an animal.
	 */
	public AnimalTypes getCategory(){
		return category;
	}
}
