
/**
 * Trie class that creates an instance of a trie data structure when called upon.
 @author Caleb Cannon
 @version 4/2/24
 */

public class Trie {
	
	private TrieNode root;
	private int size;
	
	/**
	 * Trie constructor that intializes a root for the Trie.
	 */
	
	public Trie() {
		root = new TrieNode('0');
	}
	
	/**
	 * @param word
	 * @return boolean
	 * Add method that takes in a word, and adds new trie nodes if letter is not already present in the trie.
	 */
	
	public boolean add(String word) {
		TrieNode current = root;
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(current.children[c - 'a'] == null) {
				current.children[c - 'a'] = new TrieNode(c);
			}
			current = current.children[c - 'a'];
		}
		current.flag = true;
		size++;
		return true;
	}
	
	/**
	 * @param word
	 * @return TrieNode
	 * Method used to check if a word or prefix is present in a list. Returns a TrieNode if present, and null if not.
	 */
	
	public TrieNode getNode(String word) {
		TrieNode current = root;
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if(current.children[c - 'a'] == null) {
				return null;
			}
			current = current.children[c - 'a'];
		}
		return current;
	}
	
	/**
	 * @param word
	 * @return boolean
	 * Method to check if word is contained in Trie using the flag value, which is present at the end of a word.
	 */
	
	public boolean contains(String word) {
		TrieNode lastVal = getNode(word);
		if(lastVal == null) {
			return false;
		}
		else if(lastVal.flag == true) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	/**
	 * @param pre
	 * @return boolean
	 * Method to check if letters contained in trie are a prefix. Returns false if not prefix, true if it is a prefix.
	 */
	
	public boolean containsPrefix(String pre) {
		if (getNode(pre) != null) {
			return true;
		}
		return false;
	}
	
	/**
	 * @return size
	 * Simple method that returns the size field. Size is incremented in the add method.
	 */
	
	public int size() {
		return size;
	}
	
	/**
	 * Nested TrieNode class, which allows us to create nodes with a specific letter, a possible 
	 * flag for signaling the end of a word, and the possible 26 children of the node. 
	 */
	
	protected class TrieNode {
		public char c;
		public boolean flag;
		public TrieNode[] children;
		
		public TrieNode(char c) {
			this.c = c;
			flag = false;
			children = new TrieNode[26];
		}
	}
}