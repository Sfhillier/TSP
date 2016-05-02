/**
 * 
 */

/**
 * @author Scott Hillier
 *
 */
public class City {

	/**
	 * 
	 */
	// Instance variables
	protected int id;
	protected double xCoord;
	protected double yCoord;
	
	/*
	 * Standard constructor with an id as well
	 * as the x and y coordinates of the city
	 */
	public City(int id, double xCoord, double yCoord){
		this.id = id;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
	}

	// Getter method for the city's ID
	public int getID(){
		return id;
	}
	
	// Getter method for the city's xCoord
	public double getX(){
		return xCoord;
	}
	
	// Getter method for the city's yCoord
	public double getY(){
		return yCoord;
	}
	
	/**
	 * @return String representation of the city including
	 * the id, xCoord, and yCoord of the speicified city
	 */
	public String toString(){
		return id + "\t" + xCoord + "\t" + yCoord;
	}
}
