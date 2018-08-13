package Graphics;

/**
 * @author Niraj Gupta
 * Class to represent the Cartesian point on the 2-D plane. 
 */
public class Point{
	private double x, y;

	/**
	 * Parameterized Constructor
	 * @param x : The point on the x-axis.
	 * @param y : The point on the y-axis.
	 */
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}

	/**
	 * @return : The point on the y-axis.
	 */
	public double getY(){
		return y;
	}

	/**
	 * @return : The point on the x-axis.
	 */
	public double getX(){
		return x;
	}

}
