package ZooManagementSystem;

public class Animals{
	private final String name;
	private double weight;
	private int age;
	private final String sound;
	private final int numberOfLegs;
	private final AnimalTypes category;
	private final AnimalsAvailable animalType;


	/**
	 * This constructor initializes the animal with all the properties
	 * @param name 
	 * @param weight
	 * @param age
	 * @param sound
	 * @param numberOfLegs
	 * @param category
	 * @param animalType
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


	public double getWeight(){
		return weight;
	}

	public void setWeight(double weight){
		this.weight = weight;
	}

	public int getAge(){
		return age;
	}

	public void setAge(int age){
		this.age = age;
	}

	public String getName(){
		return name;
	}

	public String getSound(){
		return sound;
	}

	public int getNumberOfLegs(){
		return numberOfLegs;
	}

	public AnimalsAvailable getAnimalType(){
		return animalType;
	}

	public AnimalTypes getCategory(){
		return category;
	}
}
