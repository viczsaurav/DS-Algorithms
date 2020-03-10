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

	// Recursive Search
	 public boolean searchRecursive(String word){
		return searchRecursive(root, word);
	 }

	 private boolean searchRecursive(TrieNode current, String word){
		if(word.length()==0){
			return current.endOfWord;
		}
		char ch = word.charAt(0);
		TrieNode node =  current.children.get(ch);
		if(node== null) 	return false;

		 return searchRecursive(node, word.substring(1));
	 }


	 // Recursive Delete

	public void delete(String word){
		delete(root,word);
	}

	private boolean delete(TrieNode current, String word){
		if(word.length()==0){
			// If end of word reached, check if its the last of word
			if(!current.endOfWord) 	return false;

			// Reached enOfWord, mark to delete
			current.endOfWord=false;
			//if current has no other mapping then return true (indication to
			// calling function that this reference can be deleted from map)
			return current.children.size()==0;
		}

		char ch = word.charAt(0);
		TrieNode node = current.children.get(ch);
		if (node==null) 	return false;

		// Check if the current Node is eligible for delete (means last Node with endOfWord=true)
		boolean canDeleteCurrentNode = delete(node,word.substring(1));

		// If returned true, delete the mapping of character and TrieNode reference from map
		if(canDeleteCurrentNode){
			current.children.remove(ch);
			// return true if no mappings are left in the map
			return current.children.size()==0;
		}
		return false;
	}

}
