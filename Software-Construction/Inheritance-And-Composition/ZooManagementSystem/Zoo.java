package ZooManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Zoo{
	List<Zones> listOfZone = new ArrayList<Zones>(); 

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
