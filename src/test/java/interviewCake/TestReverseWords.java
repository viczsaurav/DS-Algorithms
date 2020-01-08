package interviewCake;

import org.junit.jupiter.api.Test;

import static interviewCake.ReverseWords.reverseWords;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestReverseWords {

	// tests

	@Test
	public void oneWordTest() {
		final char[] expected = "vault".toCharArray();
		final char[] actual = "vault".toCharArray();
		reverseWords(actual);
		System.out.println(String.valueOf(actual));
		assertArrayEquals(expected, actual);
	}

	@Test
	public void twoWordsTest() {
		final char[] expected = "cake thief".toCharArray();
		final char[] actual = "thief cake".toCharArray();
		reverseWords(actual);
		System.out.println(String.valueOf(actual));
		assertArrayEquals(expected, actual);
	}

	@Test
	public void threeWordsTest() {
		final char[] expected = "get another one".toCharArray();
		final char[] actual = "one another get".toCharArray();
		reverseWords(actual);
		System.out.println(String.valueOf(actual));
		assertArrayEquals(expected, actual);
	}

	@Test
	public void multipleWordsSameLengthTest() {
		final char[] expected = "the cat ate the rat".toCharArray();
		final char[] actual = "rat the ate cat the".toCharArray();
		reverseWords(actual);
		System.out.println(String.valueOf(actual));
		assertArrayEquals(expected, actual);
	}

	@Test
	public void multipleWordsDifferentLengthsTest() {
		final char[] expected = "chocolate bundt cake is yummy".toCharArray();
		final char[] actual = "yummy is cake bundt chocolate".toCharArray();
		reverseWords(actual);
		System.out.println(String.valueOf(actual));
		assertArrayEquals(expected, actual);
	}

	@Test
	public void emptyStringTest() {
		final char[] expected = "".toCharArray();
		final char[] actual = "".toCharArray();
		reverseWords(actual);
		System.out.println(String.valueOf(actual));
		assertArrayEquals(expected, actual);
	}
}
