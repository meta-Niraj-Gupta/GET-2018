package ZooManagementSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Niraj Gupta
 * Class to represent the cage at which the animals are kept.
 */
public class Cages{
	private AnimalsAvailable animalType; //specifies the type of animal cage can hold, eg lion, parrot etc
	private int capacity;
	List<Animals> listOfAnimals = new ArrayList<>();

	/**
	 * Parameterized Constructor
	 * @param animalType : The type of the animal which is to be kept in the cage.
	 * @param capacity : The maximum capacity upto which a cage can hold animal.
	 */
	public Cages(AnimalsAvailable animalType, int capacity){
		this.animalType = animalType;
		this.capacity = capacity;
	}

	/**
	 * @return : The type of the animal.
	 */
	public AnimalsAvailable getAnimalType(){
		return animalType;
	}

	/**
	 * @param animalType : The type of the animal.
	 */
	public void setAnimalType(AnimalsAvailable animalType){
		this.animalType = animalType;
	}

	/**
	 * @return : The maximum capacity of the cage.
	 */
	public int getCapacity(){
		return capacity;
	}

	/**
	 * @param capacity : The maximum capacity of the cage.
	 */
	public void setCapacity(int capacity){
		this.capacity = capacity;
	}

	/**
	 * @return : The list of animals which are in the cage.
	 */
	public List<Animals> getListOfAnimals(){
		return listOfAnimals;
	}

	/**
	 * @param animal : Adding the animal to the cage.
	 */
	public void addAnimal(Animals animal){
		listOfAnimals.add(animal);
	}

	/**
	 * @return : True if the animal is removed, false otherwise.
	 */
	public boolean removeAnimal(){
		boolean removed = false;
		if(listOfAnimals.size() > 0){
			listOfAnimals.remove(0);
			removed = true;
		}
		return removed;
	}

	/**
	 * @return : The remaining capacity of the cage if it is not full.
	 */
	public int spareCapacity(){
		return capacity - listOfAnimals.size();
	}
}
