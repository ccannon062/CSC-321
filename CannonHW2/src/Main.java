import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Caleb Cannon
 * @version 02/09/2024
 */

public class Main {
	
	/**
	 * @param args
	 * Static main method that grabsand verifys user input using the Scanner class.
	 */

	public static void main(String[] args) {
		
		System.out.println("(A)rray or (L)inked implementation:");
		Scanner implementation = new Scanner(System.in);
		String awnser = implementation.next().toLowerCase();
		
		while (awnser.charAt(0) != 'a' && awnser.charAt(0) != 'l') {
			System.out.println("(A)rray or (L)inked implementation: ");
			awnser = implementation.next().toLowerCase();
		}
		
		System.out.println("Starting queue size: ");
		Scanner size = new Scanner(System.in);
		int minOfList = size.nextInt();
		
		if(minOfList <= 0) {
			while (minOfList <= 0) {
				System.out.println("Starting queue size: ");
				minOfList = size.nextInt();
			}
		}
		
		System.out.println("Doubling size until: ");
		Scanner untilSize = new Scanner(System.in);
		int maxOfList = untilSize.nextInt();
		
		if(maxOfList <= minOfList) {
			while (maxOfList <= minOfList) {
				System.out.println("Doubling size until: ");
				maxOfList = untilSize.nextInt();
			}
		}
		
		System.out.println("Number of peek, add, remove operations: ");
		Scanner numOperations = new Scanner(System.in);
		int peekAddRemove = numOperations.nextInt();
		
		if(peekAddRemove < 0) {
			while(peekAddRemove < 0) {
				System.out.println("Number of peek, add, remove operations: ");
				peekAddRemove = numOperations.nextInt();
			}
		}
		
		implementList(minOfList, maxOfList, peekAddRemove, awnser);
		
		numOperations.close();
		implementation.close();
		size.close();
		untilSize.close();
	}
	
	/**
	 * @param minOfList
	 * @param maxOfList
	 * @param peekAddRemove
	 * @param awnser
	 * Static helper method where the user input is implemented into a specified queue and timed based off peek, add, and remove operations 
	 */
	
	private static void implementList(int minOfList, int maxOfList, int peekAddRemove, String awnser) {
		StopWatch timer = new StopWatch();
		while(minOfList < maxOfList) {
			Queue<Integer> randList;
			if(awnser.equals("a")) {
				randList = new ArrayQueue<Integer>();
			}
			else {
				randList = new LinkedList<Integer>();
			}
			for(int i = 0; i < minOfList; i++) {
				randList.add(0);
			}
			timer.start();
			for(int i = 0; i < peekAddRemove; i++) {
				randList.add(0);
				randList.peek();
				randList.remove();
			}
			timer.stop();
			System.out.println(randList.size() + ": " + timer.getElapsedTime() + " ms");
			minOfList *= 2;
		}
	}
}
