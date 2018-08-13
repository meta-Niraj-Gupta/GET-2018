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

	public double getY(){
		return y;
	}

	public double getX(){
		return x;
	}

}
