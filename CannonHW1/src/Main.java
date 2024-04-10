
import java.util.Scanner;

/**
 * Driver code for ReadFromFile class.
 *   @author Caleb Cannon, Eli Moore
 *   @version 1/15/24
 */

public class Main {
	
	/**
	 * Creates an object of the ReadFromFile class and uses its methods.
	 */
	
	public static void main(String args[]) {
		
		System.out.println("Please enter a file name: ");
		Scanner userInput = new Scanner(System.in);
		String filename = userInput.nextLine();
		ReadFromFile file = new ReadFromFile();
		file.readFile(filename);
		file.getResults();
		userInput.close();
	}
}
