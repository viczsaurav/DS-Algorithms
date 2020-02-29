package interviewCake;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static interviewCake.StringPermutation.getPermutations;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestStringPermutation {

	// tests

	@Test
	public void emptyStringTest() {
		final Set<String> expected = new HashSet<>(Arrays.asList(""));
		final Set<String> actual = ç("");
		assertEquals(expected, actual);
	}

	@Test
	public void oneCharacterStringTest() {
		final Set<String> expected = new HashSet<>(Arrays.asList("a"));
		final Set<String> actual = getPermutations("a");
		assertEquals(expected, actual);
	}

	@Test
	public void twoCharacterStringTest() {
		final Set<String> expected = new HashSet<>(Arrays.asList("ab", "ba"));
		final Set<String> actual = getPermutations("ab");
		assertEquals(expected, actual);
	}

	@Test
	public void threeCharacterStringTest() {
		final Set<String> expected = new HashSet<>(Arrays.asList("abc", "acb", "bac", "bca",
						"cab", "cba"));
		final Set<String> actual = getPermutations("abc");
		assertEquals(expected, actual);
	}

}
