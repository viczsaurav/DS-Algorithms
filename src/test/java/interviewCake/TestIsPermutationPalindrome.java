package interviewCake;

import org.junit.jupiter.api.Test;

import static interviewCake.IsPermutationPalindrome.hasPalindromePermutation;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestIsPermutationPalindrome {

	// tests

	@Test
	public void permutationWithOddNumberOfCharsTest() {
		final boolean result = hasPalindromePermutation("aabcbcd");
		assertTrue(result);
	}

	@Test
	public void permutationWithEvenNumberOfCharsTest() {
		final boolean result = hasPalindromePermutation("aabccbdd");
		assertTrue(result);
	}

	@Test
	public void noPermutationWithOddNumberOfChars() {
		final boolean result = hasPalindromePermutation("aabcd");
		assertFalse(result);
	}

	@Test
	public void noPermutationWithEvenNumberOfCharsTest() {
		final boolean result = hasPalindromePermutation("aabbcd");
		assertFalse(result);
	}

	@Test
	public void emptyStringTest() {
		final boolean result = hasPalindromePermutation("");
		assertTrue(result);
	}

	@Test
	public void oneCharacterStringTest() {
		final boolean result = hasPalindromePermutation("a");
		assertTrue(result);
	}
}
