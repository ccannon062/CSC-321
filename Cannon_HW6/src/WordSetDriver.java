import java.util.Scanner;
import java.io.File;

/**
 * @author Caleb Cannon
 * @version 04/11/24
 * Simple driver class that utilizes the WordSet class.
 */

public class WordSetDriver {
	/**
	 * @param args
	 * @throws java.io.FileNotFoundException
	 * Simple static method for testing WordSet class.
	 */
	public static void main(String[] args) throws java.io.FileNotFoundException {
		WordSet fileContents = new WordSet();
		System.out.println("Please enter a file name: ");
		Scanner userFile = new Scanner(System.in);
		String filename = userFile.next();
		Scanner input = new Scanner(new File(filename));
		while(input.hasNext()) {
			fileContents.add(input.next());
		}
		System.out.println("\nThe file " + filename + " contains " + fileContents.size() + " unique word(s).\n");
		System.out.println(fileContents.toString());
		userFile.close();
	}
}
