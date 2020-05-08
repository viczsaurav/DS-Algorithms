package interviewCake;

import java.util.HashMap;
import java.util.Map;

public class TrieSearchEngine {

	static class Trie {

		static class TrieNode {

			Map<Character, TrieNode> children;
			Boolean endOfWord;

			public TrieNode() {
				this.children = new HashMap<>();
				this.endOfWord = false;
			}
		}

		private final TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public boolean addWord(String word) {
			TrieNode current = root;
			boolean isNewWord = false;

			for (char ch : word.toCharArray()) {
				TrieNode node = current.children.get(ch);
				if (node == null) {
					node = new TrieNode();
					current.children.put(ch, node);
				}
				current = node;
			}
			if (!current.endOfWord) isNewWord = true;
			current.endOfWord = true;
			return isNewWord;
		}
	}
}

