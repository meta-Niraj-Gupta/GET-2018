package ZooManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Cages{
	private AnimalsAvailable animalType; //specifies the type of animal cage can hold, eg lion, parrot etc
	private int capacity;
	List<Animals> listOfAnimals = new ArrayList<>();

	public Cages(AnimalsAvailable animalType, int capacity){
		this.animalType = animalType;
		this.capacity = capacity;
	}

	public AnimalsAvailable getAnimalType(){
		return animalType;
	}

	public void setAnimalType(AnimalsAvailable animalType){
		this.animalType = animalType;
	}

	public int getCapacity(){
		return capacity;
	}

	public void setCapacity(int capacity){
		this.capacity = capacity;
	}

	public List<Animals> getListOfAnimals(){
		return listOfAnimals;
	}

	public void addAnimal(Animals animal){
		listOfAnimals.add(animal);
	}

	public boolean removeAnimal(){
		boolean removed = false;
		if(listOfAnimals.size() > 0){
			listOfAnimals.remove(0);
			removed = true;
		}
		return removed;
	}

	public int spareCapacity(){
		return capacity - listOfAnimals.size();
	}
}
