import java.io.File;
import java.util.Scanner;

public class TrieDriver {
	public static void main(String[] args) throws java.io.FileNotFoundException{
		Trie dictionTrie = new Trie();
		Scanner input = new Scanner(new File("dictionary.txt"));
		while(input.hasNext()) {
			dictionTrie.add(input.next());
		}
		
		try (Scanner user = new Scanner(System.in)) {
			System.out.println("Enter a sequence (blank like to end):");
			String awnser = user.nextLine().toLowerCase();
			while(awnser.length() > 0) {
				if(dictionTrie.contains(awnser)) {
					System.out.println(awnser + " is a word.");
				}
				else if(dictionTrie.containsPrefix(awnser)) {
					System.out.println(awnser + " is a prefix.");
				}
				else {
					System.out.println(awnser + " is neither a word or a prefix.");
				}
				System.out.println("Enter again:");
				awnser = user.nextLine().toLowerCase();
			}
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid input, please try again.");
		}
	    System.out.println("DONE.");
	}
}
