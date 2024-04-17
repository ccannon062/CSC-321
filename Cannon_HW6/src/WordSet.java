import java.util.TreeSet;
/**
 * @author Caleb Cannon
 * @version 04/11/24
 * Simple class that creates and adds to a word set, providing methods to display data.
 */

public class WordSet {
	private TreeSet<String> words;
	private int size;
	
	/**
	 * Constructor intializes the TreeSet data structure, which will contain strings.
	 */
	
	public WordSet() {
		this.words = new TreeSet<String>();
	}
	
	/**
	 * @param word
	 * @return boolean
	 * Add method that strips special characters, and adds to the TreeSet if word is not already present.
	 */
	
	public boolean add(String word) {
		int start = 0;
		int end = word.length() - 1;
		while(start <= end && !Character.isLetterOrDigit(word.charAt(start))) {
			start++;
		}
		while(end >= start && !Character.isLetterOrDigit(word.charAt(end))) {
			end--;
		}
		String stripWord = word.substring(start, end + 1).toLowerCase();
		if(stripWord.isEmpty()) {
			return false;
		}
		if(!words.contains(stripWord)) {
			words.add(stripWord);
			size++;
			return true;
		}
		return false;
	}
	
	/**
	 * @return size
	 * Method that returns the size value which is incremented in the add method.
	 */
	
	public int size() {
		return size;
	}
	
	/**
	 * @return String
	 * getLongest method that finds the largest word in the TreeSet and returns it.
	 */
	
	public String getLongest() {
		String largest = words.first();
		for(String s: words) {
			if (largest.length() < s.length()) {
				largest = s;
			}
		}
		return largest;
	}
	
	/**
	 * @return String
	 * Overwritten toString method that places TreeSet values into 5 neat columns, with size of columns dependant upon the largest word.
	 */
	
	@Override
	public String toString() {
		if(words.size() <= 0) {
			return "";
		}
		int maxSize = getLongest().length();
		int colNum = 0;
		StringBuilder formattedString = new StringBuilder();
		for(String q: words) {
			if(colNum == 5) {
				formattedString.append("\n");
				colNum = 0;
			}
			formattedString.append(String.format("%-" + (maxSize + 1) + "s", q));
			colNum++;
		}
		return formattedString.toString();
	}

}
