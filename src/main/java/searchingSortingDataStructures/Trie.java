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
				node = node==null? new TrieNode(): node;
				current.children.put(ch,node);
				current=node;
			}
			// Word insert is complete, mark the endOfWord as true
			current.endOfWord=true;
	}

	// Recursive Inserts
	public void insertResursive(String word){
		insertRecursive(root,word);
	}

	private void insertRecursive(TrieNode current, String word){
		if(word.length()==0){
			current.endOfWord=true;
			return;
		}

		char ch = word.charAt(0);
		TrieNode node = current.children.get(ch);
		if (node == null) {
			node = new TrieNode();
			current.children.put(ch, node);
		}

		insertRecursive(node, word.substring(1));
	}

	// Iterative search
	public boolean search(String word){
		TrieNode current = root;

		for (char ch: word.toCharArray()){
			TrieNode node = current.children.get(ch);
			if(node==null)
				return false;
			current= node;
		}
		return current.endOfWord;
	}

	 public boolean searchRecursive(String word){
		return searchRecursive(root, word);
	 }

	 private boolean searchRecursive(TrieNode current, String word){
		if(word.length()==0){
			return current.endOfWord;
		}
		char ch = word.charAt(0);
		TrieNode node =  current.children.get(ch);
		if(node== null)
			return false;

		 return searchRecursive(node, word.substring(1));
	 }

}
