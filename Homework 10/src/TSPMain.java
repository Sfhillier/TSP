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
		//String fileName = args[0];
		String fileName = "dj38.tsp";

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
		System.out.println(cities.size());

		// Close the BufferedReader to prevent memory leaks
		br.close();
		
		// Randomizing the first solution to the search
		//----------------------------------------------
		// Integer to keep track of the path
		int pathCost = 0;
		// Random number to choose the first city
		Random rand = new Random();
		int firstCity = cities.get(rand.nextInt(cities.size()-1)+1).getID();
		// Empty set of visited cities
		ArrayList<City> visitedCities = new ArrayList<City>();
		while(!cities.isEmpty()){
			
		}
	}
}
