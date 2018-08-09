package ZooManagementSystem;

/**
 * @author Niraj Gupta
 * Class to represent the zone at which the birds are kept and is sub class of Zones.
 */
public class BirdZone extends Zones{
	/**
	 * Parameterized Constructor
	 * @param capacity : The maximum capacity the zone has.
	 * @param hasPark : The zone has park or not.
	 * @param hasCanteen : The zone has canteen or not.
	 */
	public BirdZone(int capacity, boolean hasPark, boolean hasCanteen){
		super(AnimalTypes.BIRD, capacity, hasPark, hasCanteen);
	}
}
