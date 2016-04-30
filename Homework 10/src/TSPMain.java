import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 */

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
				System.out.println(line);
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
		int index = 0;
		for(int i = 0; i < text.size(); i++){
			String nextLine = text.get(i);
			do{
				firstPart += nextLine.charAt(index);
				index++;
			}while(nextLine.charAt(index) != ' ');

			do{
				secondPart += nextLine.charAt(index);
				index++;
			}while(nextLine.charAt(index) != ' ');

			do{
				thirdPart += nextLine.charAt(i);
				index++;
			}while(nextLine.charAt(i) != ' ');
			index = 0;
			System.out.println("This is testing my strings" + firstPart + "\t" + secondPart + "\t" + thirdPart);
		}
		// Prints out the size of the text ArrayList for
		// testing purposes to make sure that the 
		// invalid lines are being ignored properly
		System.out.println(text.size());

		// Close the BufferedReader to prevent memory leaks
		br.close();
	}

}
