package ZooManagementSystem;

public class Birds extends Animals{
	private final boolean canFly;
	private double flyHeight;

	public Birds(String name, double weight, int age, String sound,
			int numberOfLegs, boolean canFly, double flyHeight, AnimalsAvailable animalType){

		super(name, weight, age, sound, numberOfLegs, AnimalTypes.BIRD, animalType);

		this.canFly = canFly;
		this.flyHeight = flyHeight;
	}	

	public double getflyHeight(){
		return flyHeight;
	}

	public void setflyHeight(double flyHeight){
		this.flyHeight = flyHeight;
	}

	public boolean canFly(){
		return canFly;
	}

}
