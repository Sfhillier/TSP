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
			
			text.add(line);
			line = br.readLine();
		}
		
		// Loop to iterate through 
		for(int i = 0; i < text.size(); i++){
			if(Character.isDigit(text.get(i).charAt(0))){
				System.out.println(text.get(i));
			}
			else if(!Character.isDigit(text.get(i).charAt(0))){
				text.remove(i);
			}
		}
		
		System.out.println(text.size());
		// Close the BufferedReader to prevent memory leaks
		br.close();
	}
	
}
