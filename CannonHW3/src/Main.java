import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Caleb Cannon
 * @version 02/22/2024
 */

public class Main {
	
	/**
	 * @param args
	 * Static main method that grabs and verifys user input using the Scanner class.
	 * Utilizes helper method to do list timings.
	 */
	
	public static void main(String[] args) {
		
		System.out.println("Please enter the initial size for your lists: ");
		Scanner userInput1 = new Scanner(System.in);
		int initialSize = userInput1.nextInt();
		while(initialSize <= 0) {
			System.out.println("Please enter the initial size for your lists: ");
			initialSize = userInput1.nextInt();
		}
		System.out.println("Please enter the final size for your lists: ");
		Scanner userInput2 = new Scanner(System.in);
		int finalSize = userInput2.nextInt();
		while(finalSize <= initialSize) {
			System.out.println("Please enter the final size for your lists: ");
			finalSize = userInput2.nextInt();
		}
		timeLists(initialSize, finalSize);
		userInput1.close();
		userInput2.close();
		
	}
	
	/**
	 * @param initialSize
	 * @param finalSize
	 * Static helper method that times the get operation on three lists and displays them in a neat format.
	 */
	
	private static void timeLists(int initialSize, int finalSize) {
		
		while(initialSize < finalSize) {
			LinkedList<Integer> timeLink = new LinkedList<Integer>();
			ArrayList<Integer> timeArray = new ArrayList<Integer>();
			ComboList<Integer> timeCombo = new ComboList<Integer>(10);
			for(int i = 0; i < initialSize; i++) {
				timeLink.add(i);
				timeArray.add(i);
				timeCombo.add(i);
			}
			StopWatch linkTimer = new StopWatch();
			linkTimer.start();
			for(int i = 0; i < initialSize - 1; i++) {
				timeLink.get(i);
			}
			linkTimer.stop();
			StopWatch arrayTimer = new StopWatch();
			arrayTimer.start();
			for(int i = 0; i < initialSize - 1; i++) {
				timeArray.get(i);
			}
			arrayTimer.stop();
			StopWatch comboTimer = new StopWatch();
			comboTimer.start();
			for(int i = 0; i < initialSize - 1; i++) {
				timeCombo.get(i);
			}
			comboTimer.stop();
			
			System.out.println("[" + initialSize + "]" + "[A]: " + arrayTimer.getElapsedTime() +
					" [L]: " + linkTimer.getElapsedTime() + " [C]: " + comboTimer.getElapsedTime());
			initialSize *= 2;
		}
		
	}
	
}
