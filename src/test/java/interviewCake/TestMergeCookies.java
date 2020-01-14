package interviewCake;

import org.junit.jupiter.api.Test;

import static interviewCake.MergeCookies.mergeArrays;
import static interviewCake.ReverseWords.reverseWords;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestMergeCookies {

	// tests

	@Test
	public void bothArraysAreEmptyTest() {
		final int[] myArray = {};
		final int[] alicesArray = {};
		final int[] expected = {};
		final int[] actual = mergeArrays(myArray, alicesArray);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void firstArrayIsEmptyTest() {
		final int[] myArray = {};
		final int[] alicesArray = {1, 2, 3};
		final int[] expected = {1, 2, 3};
		final int[] actual = mergeArrays(myArray, alicesArray);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void secondArrayIsEmptyTest() {
		final int[] myArray = {5, 6, 7};
		final int[] alicesArray = {};
		final int[] expected = {5, 6, 7};
		final int[] actual = mergeArrays(myArray, alicesArray);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void bothArraysHaveSomeNumbersTest() {
		final int[] myArray = {2, 4, 6};
		final int[] alicesArray = {1, 3, 7};
		final int[] expected = {1, 2, 3, 4, 6, 7};
		final int[] actual = mergeArrays(myArray, alicesArray);
		assertArrayEquals(expected, actual);
	}

	@Test
	public void arraysAreDifferentLengthsTest() {
		final int[] myArray = {2, 4, 6, 8};
		final int[] alicesArray = {1, 7};
		final int[] expected = {1, 2, 4, 6, 7, 8};
		final int[] actual = mergeArrays(myArray, alicesArray);
		assertArrayEquals(expected, actual);
	}

}
