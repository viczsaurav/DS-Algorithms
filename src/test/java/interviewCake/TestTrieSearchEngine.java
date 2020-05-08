package interviewCake;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestTrieSearchEngine {

	// tests

	@Test
	public void trieTest() {
		final TrieSearchEngine.Trie trie = new TrieSearchEngine.Trie();

		boolean result = trie.addWord("catch");
		assertTrue(result);

		result = trie.addWord("cakes");
		assertTrue(result);

		result = trie.addWord("cake");
		assertTrue(result);

		result = trie.addWord("cake");
		assertFalse(result);

		result = trie.addWord("caked");
		assertTrue(result);

		result = trie.addWord("catch");
		assertFalse(result);

		result = trie.addWord("");
		assertTrue(result);

		result = trie.addWord("");
		assertFalse(result);
	}
}
