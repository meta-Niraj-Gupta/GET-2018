package ZooManagementSystem;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestZooManagementSystem{

	@Test
	public void addZone_HappyFlow(){
		Zoo zoo = new Zoo();
		assertTrue(zoo.addZone(AnimalTypes.MAMMAL, 2, true, true));
		assertTrue(zoo.addZone(AnimalTypes.BIRD, 2, false, true));
		assertTrue(zoo.addZone(AnimalTypes.REPTILE, 2, false, false));
		assertTrue(zoo.addZone(AnimalTypes.BIRD, 2, false, true));
	}


	@Test
	public void addCage_HappyFlow(){
		Zoo zoo = new Zoo();
		zoo.addZone(AnimalTypes.MAMMAL, 2, true, true);
		assertTrue(zoo.addCage(AnimalsAvailable.LION, 3));
	}

	@Test(expected = AssertionError.class)
	public void addCage_Exception_WhenAddingDifferentCageToDifferentZone(){
		Zoo zoo = new Zoo();
		zoo.addZone(AnimalTypes.BIRD, 2, true, true);
		zoo.addCage(AnimalsAvailable.LION, 3);
	}

	@Test(expected = AssertionError.class)
	public void addCage_Exception_WhenAddingAnimalMoreThanTheCapacityOfZone(){
		Zoo zoo = new Zoo();
		zoo.addZone(AnimalTypes.MAMMAL, 2, true, true);
		zoo.addCage(AnimalsAvailable.LION, 3);
		zoo.addCage(AnimalsAvailable.LION, 3);
		zoo.addCage(AnimalsAvailable.LION, 3); 
	}

	@Test
	public void addAnimal_HappyFlow(){
		Zoo zoo = new Zoo();
		zoo.addZone(AnimalTypes.MAMMAL, 2, true, true);
		zoo.addCage(AnimalsAvailable.LION, 3);
		assertTrue(zoo.addAnimal(new Lion(25, 12)));
	}

	@Test(expected = AssertionError.class)
	public void addAnimal_Exception_WhenAddingDifferentAnimalToDifferentCage(){
		Zoo zoo = new Zoo();
		zoo.addZone(AnimalTypes.MAMMAL, 2, true, true);
		zoo.addCage(AnimalsAvailable.ELEPHANT, 3);
		assertTrue(zoo.addAnimal(new Lion(25, 12)));
	}

	@Test
	public void removeAnimal_HappyFlow(){
		Zoo zoo = new Zoo();
		zoo.addZone(AnimalTypes.MAMMAL, 2, true, true);
		zoo.addCage(AnimalsAvailable.LION, 3);
		zoo.addAnimal(new Lion(25, 12));
		assertTrue(zoo.removeAnimal(AnimalsAvailable.LION));
	}

	@Test(expected = AssertionError.class)
	public void removeAnimal_Exception_WhenRemovingAnimalWhichIsNotPresent(){
		Zoo zoo = new Zoo();
		zoo.addZone(AnimalTypes.MAMMAL, 2, true, true);
		zoo.addCage(AnimalsAvailable.LION, 3);
		zoo.addAnimal(new Lion(25, 12));
		zoo.removeAnimal(AnimalsAvailable.ELEPHANT);
	}
}
