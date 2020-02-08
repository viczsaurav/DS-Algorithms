package interviewCake;

import org.junit.jupiter.api.Test;

import static interviewCake.FindRepeat.findRepeat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFindRepeat {

	// tests

	@Test
	public void justTheRepeatedNumberTest() {
		final int[] numbers = {1, 1};
		final int expected = 1;
		final int actual = findRepeat(numbers);
		assertEquals(expected, actual);
	}

	@Test
	public void shortArrayTest() {
		final int[] numbers = {1, 2, 3, 2};
		final int expected = 2;
		final int actual = findRepeat(numbers);
		assertEquals(expected, actual);
	}

	@Test
	public void mediumArrayTest() {
		final int[] numbers = {1, 2, 5, 5, 5, 5};
		final int expected = 5;
		final int actual = findRepeat(numbers);
		assertEquals(expected, actual);
	}

	@Test
	public void longArrayTest() {
		final int[] numbers = {4, 1, 4, 8, 3, 2, 7, 6, 5};
		final int expected = 4;
		final int actual = findRepeat(numbers);
		assertEquals(expected, actual);
	}
}
