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
		String fileName = args[0];
		
		// Buffered reader and FileReader objects to grab each line
		// of the text file and an ArrayList to store each line
		// which is contained within the line variable
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		ArrayList<String> text = new ArrayList<String>();
		String line = br.readLine();
		while(line != null){
			
			text.add(line);
		}
		br.close();
	}

}
