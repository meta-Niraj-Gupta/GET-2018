package ZooManagementSystem;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Niraj Gupta
 * Class to represent the Zoo which has zones and animals.
 */
public class Zoo{
	List<Zones> listOfZone = new ArrayList<Zones>(); 

	/**
	 * Method to add the zone into the zoo.
	 * @param zoneType : The type of the zone which is to be added.
	 * @param capacity : The capacity of the zone i.e. how many cages it can have.
	 * @param hasPark : Whether the zone has park or not.
	 * @param hasCanteen : Whether the zone has canteen or not.
	 * @return : True if the zone is added, false otherwise.
	 */
	public boolean addZone(AnimalTypes zoneType, int capacity, boolean hasPark, boolean hasCanteen){
		Zones zone = null;
		switch(zoneType){
		case BIRD:	  
			zone = new BirdZone(capacity, hasPark, hasCanteen);
			break;
		case MAMMAL:  
			zone = new MammalsZone(capacity, hasPark, hasCanteen);
			break;
		case REPTILE: 
			zone = new ReptilesZone(capacity, hasPark, hasCanteen);
			break;		
		}
		listOfZone.add(zone);
		return true;
	}

	/**
	 * Method to add cage to the zones.
	 * @param animal : The animal type for which the cage is defined.
	 * @param capacity : The capacity of the cage.
	 * @return : True if the cage is addded successfully, false otherwise.
	 */
	public boolean addCage(AnimalsAvailable animal, int capacity){
		Cages cage = new Cages(animal, capacity);
		boolean flag = false;
		for(Zones zone: listOfZone){
			if(zone.spareCapacity() != 0){
				// check for a specific zone type and their animals
				if(zone.getZoneType() == AnimalTypes.BIRD 
						&& (animal.equals(AnimalsAvailable.PARROT) 
								|| animal.equals(AnimalsAvailable.PEACOCK))){

					zone.addCage(cage);
					flag = true;
					break;
				}else if(zone.getZoneType() == AnimalTypes.MAMMAL 
						&& (animal.equals(AnimalsAvailable.LION) 
								|| animal.equals(AnimalsAvailable.ELEPHANT))){

					zone.addCage(cage);
					flag = true;
					break;
				}else if(zone.getZoneType() == AnimalTypes.REPTILE 
						&& (animal.equals(AnimalsAvailable.CROCODILE) 
								|| animal.equals(AnimalsAvailable.SNAKE))){

					zone.addCage(cage);
					flag = true;
					break;
				}	
			}			
		}
		if(!flag){
			throw new AssertionError("You need to add a zone first!!");
		}
		return flag;
	}

	/**
	 * Method to add animal to the cage.
	 * @param animal : The animal which is to be added to the cage.
	 * @return : True if the animal is successfully added to the cage.
	 */
	public boolean addAnimal(Animals animal){
		boolean flag = false;
		for(Zones zone: listOfZone){
			if(zone.getZoneType().equals(animal.getCategory()) && zone.addAnimal(animal)){
				flag = true;
				break;
			}
		}

		if(!flag){
			throw new AssertionError("All zones are full!!You need to add a zone first!!");
		}
		return flag;
	}

	/**
	 * Method to remove the animal from the zone.
	 * @param animal : The animal which is to be removed from the zone.
	 * @return : True if the animal is successfully removed from the zone, false otherwise.
	 */
	public boolean removeAnimal(AnimalsAvailable animal){
		boolean flag = false;
		AnimalTypes category = null;
		switch(animal){
		case CROCODILE: 
			category = AnimalTypes.REPTILE;
			break;
		case ELEPHANT:
			category = AnimalTypes.MAMMAL;
			break;
		case LION:
			category = AnimalTypes.MAMMAL;
			break;
		case PARROT:
			category = AnimalTypes.BIRD;
			break;
		case PEACOCK:
			category = AnimalTypes.BIRD;
			break;
		case SNAKE:
			category = AnimalTypes.REPTILE;
			break;
		}
		for(Zones zone: listOfZone){
			if(zone.getZoneType().equals(category) && zone.removeAnimal(animal)){
				flag = true;
				break;
			}
		}
		if(!flag){
			throw new AssertionError("Animal not found!");
		}
		return flag;
	}
}
