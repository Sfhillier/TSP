import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


/**
 * @author Scott Hillier
 * @category Homework 10
 * @since 04/08/2016
 *
 */
public class TSPMain {

	/**
	 * @param args
	 * Reads in file name from command line
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// String variable to store the command line
		// input for the filename to be searched
		String fileName = args[0];
		//String fileName = "dj38.tsp";

		// Buffered reader and FileReader objects to grab each line
		// of the text file and an ArrayList to store each line
		// which is contained within the line variable
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		ArrayList<String> text = new ArrayList<String>();
		String line = br.readLine();

		// While loops that parses each line of the text and
		// Only adds it to the ArrayList if it will be needed for the
		// TSP search
		while(line != null){
			// Checks the line and only adds it to the
			// arrayList if the first character is a number
			// because many of the lines are just comments
			if(Character.isDigit(line.charAt(0))){
				text.add(line);
				/**
				 * Prints the line, but this is just for testing while 
				 * working on the project
				 */
				//System.out.println(line);
			}
			// Reads the next line
			line = br.readLine();
		}

		// ArrayList to store all of the cities
		ArrayList<City> cities = new ArrayList<City>();
		// For loop to iterate through each line in text
		// and convert that to a city object
		// with an id, and x and y coordinates
		String firstPart = "", secondPart = "", thirdPart = "";

		for(int i = 0; i < text.size(); i++){
			// Temporary string for each line to be parsed
			String nextLine = text.get(i);
			// First part creates a substring from the first character to the first space
			// which is used to hold the id
			firstPart = nextLine.substring(0, nextLine.indexOf(' '));
			// Second part creates a substring of nextLine that starts at 1 index past the end 
			// of firstPart and ends at the first space encountered when moving backwards from the end
			// of the string
			secondPart = nextLine.substring(firstPart.length()+1, nextLine.lastIndexOf(' ', nextLine.length()));
			// Third part creates a substring of nextLine that starts at the last space
			// and ends at the end, this is possible because there is no space at the end
			// of each line
			thirdPart = nextLine.substring(nextLine.lastIndexOf(' '));
			// Parses each substring to an int or double and uses them as parameters
			// to create city objects which it adds to its cities list
			cities.add(new City(Integer.parseInt(firstPart), Double.parseDouble(secondPart), Double.parseDouble(thirdPart)));
		}

		// Prints out the size of the text ArrayList for
		// testing purposes to make sure that the 
		// invalid lines are being ignored properly
		//System.out.println(cities.size());

		// Close the BufferedReader to prevent memory leaks
		br.close();

		// Randomizing the first solution to the search
		//----------------------------------------------
		// Integer to keep track of the path
		int pathCost = 0;
		// Random number to choose the first city
		Random rand = new Random();
		// Randomly generates an index for the first city where the first number is 1
		int firstCity = cities.get(rand.nextInt(cities.size()-1)+1).getID();
		// Initializes an index for the next city to be 0
		int nextCity = 0;
		// Empty set of visited cities
		ArrayList<City> visitedCities = new ArrayList<City>();
		// Adds the first city to the visited list
		visitedCities.add(cities.get(firstCity));
		int index = 0;
		// Removes that city from the original cities list
		//cities.remove(firstCity);
		// Iterates through the list until no more cities are left
		while(visitedCities.size() <= cities.size()){
			// Generates a random city and then checks to see if it
			// is already in the visited list
			do{
				nextCity = cities.get(rand.nextInt(cities.size()-1)).getID();
			}while(visitedCities.get(index).id == cities.get(index).getID());
			// If this is a new city, then the distance between the two most
			// recent cities is calculated and added to the path
			//pathCost += getDistance(visitedCities.get(index), cities.get(nextCity));
			visitedCities.add(cities.get(nextCity));
			index++;
			//cities.remove(nextCity);
		}
		// Closes off the path by going back to the first city
		pathCost+= getDistance(visitedCities.get(index), cities.get(0));
		// Prints the solution
		for(int i = 0; i < visitedCities.size(); i++){
			//System.out.println(visitedCities.get(i).toString());
			
			// Adds the next distance to the total path cost
			if(i < visitedCities.size()-1){
				pathCost += getDistance(visitedCities.get(i), visitedCities.get(i+1));
			}
			// Contingency that grabs the last distance as the distance from the last
			// city back to the first, since otherwise it would return an array 
			// out of bounds exception
			else if(i == visitedCities.size()-1){
				pathCost += getDistance(visitedCities.get(i), visitedCities.get(0));
			}
		}
		
		int firstRandom = 0;
		int secondRandom = 0;
		int newPath = 0;
		//Randomizing to get a better solution
		for(int i = 0; i < 10; i++){
			// Chooses the two indices to be swapped
			firstRandom = rand.nextInt(cities.size());
			secondRandom = rand.nextInt(cities.size());
			City temp = visitedCities.get(firstRandom);
			// Swaps values for the first and second random values selected
			cities.get(secondRandom).id = cities.get(firstRandom).id;
			cities.get(secondRandom).xCoord = cities.get(firstRandom).xCoord;
			cities.get(secondRandom).yCoord = cities.get(firstRandom).yCoord;
			
			cities.get(firstRandom).id = temp.id;
			cities.get(secondRandom).xCoord = temp.xCoord;
			cities.get(secondRandom).yCoord = temp.yCoord;
			
			for(int j = 0; j < cities.size(); j++){
				//System.out.println(visitedCities.get(i).toString());
				
				// Adds the next distance to the total path cost
				if(j < cities.size()-1){
					newPath += getDistance(cities.get(j), cities.get(j+1));
				}
				// Contingency that grabs the last distance as the distance from the last
				// city back to the first, since otherwise it would return an array 
				// out of bounds exception
				else if(j == cities.size()-1){
					newPath += getDistance(cities.get(j), cities.get(0));
				}
			}
			// Checks the new path vs the old one
			// If the new one is better it does the swaps
			// on the visitedCities list
			if (newPath < pathCost){
				// Chooses the two indices to be swapped
				City temp2 = visitedCities.get(firstRandom);
				// Swaps values for the first and second random values selected
				visitedCities.get(secondRandom).id = visitedCities.get(firstRandom).id;
				visitedCities.get(secondRandom).xCoord = visitedCities.get(firstRandom).xCoord;
				visitedCities.get(secondRandom).yCoord = visitedCities.get(firstRandom).yCoord;
				
				visitedCities.get(firstRandom).id = temp2.id;
				visitedCities.get(secondRandom).xCoord = temp2.xCoord;
				visitedCities.get(secondRandom).yCoord = temp2.yCoord;
			}
		}
		
		System.out.println(pathCost);
		// Prints out the path
		for(int i = 0; i < visitedCities.size(); i++){
			System.out.println(visitedCities.get(i).toString());
		}
	}

	/**
	 * Method to calculate the distance between two cities
	 * @param c1, c2
	 * where c1 is the first city and c2 is the second city
	 * @return the Euclidean distance as an integer value of the distance between them
	 */
	public static int getDistance(City c1, City c2){
		return (int)Math.round(Math.sqrt((c1.xCoord-c2.xCoord)*c1.xCoord-c2.xCoord)+(c1.yCoord-c2.yCoord)*(c1.yCoord-c2.yCoord));
	}

}
