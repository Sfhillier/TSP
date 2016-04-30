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
	private int id;
	private double xCoord;
	private double yCoord;
	
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
	 * Method to calculate the distance between two cities
	 * @param c1, c2
	 * where c1 is the first city and c2 is the second city
	 * @return the Euclidean distance as an integer value of the distance between them
	 */
	public int getDistance(City c1, City c2){
		return (int)Math.round(Math.sqrt((c1.xCoord-c2.xCoord)*c1.xCoord-c2.xCoord)+(c1.yCoord-c2.yCoord)*(c1.yCoord-c2.yCoord));
	}
	
}
