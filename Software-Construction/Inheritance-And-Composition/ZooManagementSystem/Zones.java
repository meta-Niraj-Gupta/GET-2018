package ZooManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Zones{
	private AnimalTypes zoneType; 
	private final int capacity;
	private List<Cages> listOfCages = new ArrayList<>();
	private boolean hasPark, hasCanteen;

	public Zones(AnimalTypes zoneType, int capacity, boolean hasPark, boolean hasCanteen){
		this.zoneType = zoneType;
		this.capacity = capacity;
		this.hasPark = hasPark;
		this.hasCanteen = hasCanteen;
	}

	public AnimalTypes getZoneType(){
		return zoneType;
	}

	public void setZoneType(AnimalTypes zoneType){
		this.zoneType = zoneType;
	}

	public List<Cages> getNoOfCages(){
		return listOfCages;
	}

	public boolean isHasPark(){
		return hasPark;
	}

	public void setHasPark(boolean hasPark){
		this.hasPark = hasPark;
	}

	public boolean isHasCanteen(){
		return hasCanteen;
	}

	public void setHasCanteen(boolean hasCanteen){
		this.hasCanteen = hasCanteen;
	}

	public int getCapacity(){
		return capacity;
	}

	public int spareCapacity(){
		return capacity - listOfCages.size();
	}

	public void addCage(Cages cage){
		if(spareCapacity() != 0){
			listOfCages.add(cage);
		}else{
			throw new AssertionError("Capacity of the zone is full! Cannot add cage!");
		}
	}

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
