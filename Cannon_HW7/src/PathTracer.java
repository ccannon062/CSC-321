import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author Caleb Cannon
 * @version 04/26/2024
 * Simple class that stores txt files as simulated finite state machines, with a loop function for conveniency.
 */


public class PathTracer {

    public static void main(String[] args) throws FileNotFoundException {
        FiniteStateMachine<String, String> fsm = new FiniteStateMachine<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter FSM file: ");
        String filename = scanner.nextLine();

        Scanner input = new Scanner(new File(filename));
            while (input.hasNextLine()) {
                String start = input.next();
                String edge = input.next();
                String end = input.next();
                fsm.addEdge(start, edge, end);
            }

        fsmLoop(fsm, scanner);
        scanner.close();
    }
    
    /**
     * @param fsm
     * @param scanner
     * Displays end state given a certain sequence.
     */

    private static void fsmLoop(FiniteStateMachine<String, String> fsm, Scanner scanner) {
        while (true) {
            System.out.print("\nEnter a starting state (* to stop): ");
            String initialState = scanner.nextLine();

            if (initialState.equals("*")) {
                break;
            }

            System.out.print("\nEnter a sequence (separated by white spaces): ");
            ArrayList<String> sequenceInput = new ArrayList<String>(Arrays.asList(scanner.nextLine().split(" ")));
            
            System.out.println("\nEnd state: " +  fsm.findEndState(initialState, sequenceInput));
        }
        System.out.println("DONE");
    }
}
