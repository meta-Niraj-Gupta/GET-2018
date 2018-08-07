package ZooManagementSystem;

/**
 * @author Niraj Gupta
 * Class to represent the zone at which the Mammals are kept and is sub class of Zones.
 */
public class MammalsZone extends Zones{

	/**
	 * Parameterized Constructor
	 * @param capacity : The maximum capacity of the zone.
	 * @param hasPark : The zone has park or not.
	 * @param hasCanteen : The zone has canteen or not.
	 */
	public MammalsZone(int capacity, boolean hasPark, boolean hasCanteen){
		super(AnimalTypes.MAMMAL, capacity, hasPark, hasCanteen);
	}
}
