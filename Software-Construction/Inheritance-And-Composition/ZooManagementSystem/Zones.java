package ZooManagementSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Niraj Gupta
 * Class to represent the zones which are available in the zoo.
 */
public class Zones{
	private AnimalTypes zoneType; 
	private final int capacity;
	private List<Cages> listOfCages = new ArrayList<>();
	private boolean hasPark, hasCanteen;

	/**
	 * Parameterized Constructor
	 * @param zoneType : The type of the zone like mammalZone, reptileZone etc.
	 * @param capacity : The maximum capacity of the zone.
	 * @param hasPark : The zone has park or not.
	 * @param hasCanteen : The zone has canteen or not.
	 */
	public Zones(AnimalTypes zoneType, int capacity, boolean hasPark, boolean hasCanteen){
		this.zoneType = zoneType;
		this.capacity = capacity;
		this.hasPark = hasPark;
		this.hasCanteen = hasCanteen;
	}

	/**
	 * @return : The type of the zone based on the animal it keeps.
	 */
	public AnimalTypes getZoneType(){
		return zoneType;
	}

	/**
	 * @param zoneType : Set the zone to the zoneType.
	 */
	public void setZoneType(AnimalTypes zoneType){
		this.zoneType = zoneType;
	}

	/**
	 * @return : The list of cage the zone is keeping.
	 */
	public List<Cages> getNoOfCages(){
		return listOfCages;
	}

	/**
	 * @return : True if the zone has park, false otherwise.
	 */
	public boolean isHasPark(){
		return hasPark;
	}

	/**
	 * @param hasPark : Set the zone hasPark if there is, otherwise not.
	 */
	public void setHasPark(boolean hasPark){
		this.hasPark = hasPark;
	}

	/**
	 * @return : True if the zone has canteen, false otherwise.
	 */
	public boolean isHasCanteen(){
		return hasCanteen;
	}

	/**
	 * @param hasCanteen : Set the zone hasCanteen if there is, otherwise not.
	 */
	public void setHasCanteen(boolean hasCanteen){
		this.hasCanteen = hasCanteen;
	}

	/**
	 * @return : The capacity of the zone upto which it can keep cages.
	 */
	public int getCapacity(){
		return capacity;
	}

	/**
	 * @return : The remaining capacity of the zone.
	 */
	public int spareCapacity(){
		return capacity - listOfCages.size();
	}

	/**
	 * @param cage : Add the cage to the zone if space is available, otherwise not.
	 */
	public void addCage(Cages cage){
		if(spareCapacity() != 0){
			listOfCages.add(cage);
		}else{
			throw new AssertionError("Capacity of the zone is full! Cannot add cage!");
		}
	}

	/**
	 * Method to add animal to the cage in a particular zone.
	 * @param animal : The animal which is to be added to the cage.
	 * @return : True if the animal is successfully added to the cage, false otherwise.
	 */
	public boolean addAnimal(Animals animal){
		boolean flag = false;
		for(Cages cage: listOfCages){
			if(cage.getAnimalType().equals(animal.getAnimalType()) && cage.spareCapacity() != 0){
				flag = true;
				cage.addAnimal(animal);
				break;
			}	
		}
		if(!flag){
			throw new AssertionError("Capacity of the zone is full! Cannot add animal!");
		}
		return flag;
	}

	/**
	 * Method to remove the animal from the cage.
	 * @param animal : The animal which is to be removed.
	 * @return : True if the animal is removed, false otherwise.
	 */
	public boolean removeAnimal(AnimalsAvailable animal){
		boolean removed = false;
		for(Cages cage: listOfCages){
			if(cage.getAnimalType().equals(animal)){
				removed = cage.removeAnimal();
			}
		}
		return removed;
	}
}
