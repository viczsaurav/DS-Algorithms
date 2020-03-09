package searchingSortingDataStructures;

import java.util.HashMap;
import java.util.Map;

public class Trie {

	private class TrieNode{
		Map<Character, TrieNode> children;
		Boolean endOfWord;

		public TrieNode(){
			this.children = new HashMap<>();
			this.endOfWord = false;
		}
	}

	private final TrieNode root;

	public Trie(){
		root = new TrieNode();
	}

	// Iterative Insert
	public void insertNode(String word){
			TrieNode current = root;
			for(char ch: word.toCharArray()){
				TrieNode node = current.children.get(ch);
				if(node==null){
					node = new TrieNode();
					current.children.put(ch,node);
				}
				current=node;
			}
			// Word insert is complete, mark the endOfWord as true
			current.endOfWord=true;
	}

	public void insertResursive(String word){

	}
}
