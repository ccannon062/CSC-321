import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Class that validates credit card numbers.
 *   @author Caleb Cannon, Eli Moore
 *   @version 1/15/24
 */

public class ReadFromFile {
	
	/**
	   * Arraylist to store final results
	   */
	
	private ArrayList<String> cardNums = new ArrayList<>();
	
	/**
	   * Reads from user inputted file.
	   * @param name of the file.
	   */
	
	public void readFile(String filename) {
		System.out.print("\n");
		try {
			Scanner scanner = new Scanner(new File(filename));
			
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				line = line.replaceAll("\\W", "");
				boolean result = luhnFormula(line);
				if(result == true) {
					cardNums.add(line + " VALID");
				}
				else {
					cardNums.add(line + " INVALID");
				}
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("Sorry, but your file was not available.");
		}	
	}
	
	/**
	   * Uses the Luhn Formula to calculate a checksum (total).
	   * @param a single card number passed from the ReadFile method.
	   * @return boolean value back to readFile method.
	   */
	
	public boolean luhnFormula(String card) {
		int total = 0;
		int loopTotal = 0;
		for(int i = card.length() - 1; i >= 0; i--) {
			loopTotal += 1;
			int newNum = Character.getNumericValue(card.charAt(i));
			if(loopTotal % 2 == 0) {
				int temp =  newNum * 2;
				if (temp >= 10) {
					String overTen = Integer.toString(temp);
					for(int j = 0; j < overTen.length(); j++) {
						int splitNum = Character.getNumericValue(overTen.charAt(j));
						total += splitNum;
					}
				}
				else {
					total += temp;
				}
			}
			else {
				total += newNum;
			}
		}
		if (total % 10 == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	   * Simple method to print out the final results in the specified format.
	   */
	
	public void getResults() {
		for(int i = 0; i < cardNums.size(); i++) {
			System.out.println(cardNums.get(i));
		}
	}
	
}