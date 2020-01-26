package interviewCake;

import org.junit.jupiter.api.Test;

import static interviewCake.HighestProductOf3.highestProductOf3;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestHighestProductOf3 {
	// tests

	@Test
	public void shortArrayTest() {
		final int actual = highestProductOf3(new int[] {1, 2, 3, 4});
		final int expected = 24;
		assertEquals(expected, actual);
	}

	@Test
	public void longerArrayTest() {
		final int actual = highestProductOf3(new int[] {6, 1, 3, 5, 7, 8, 2});
		final int expected = 336;
		assertEquals(expected, actual);
	}

	@Test
	public void arrayHasOneNegativeTest() {
		final int actual = highestProductOf3(new int[] {-5, 4, 8, 2, 3});
		final int expected = 96;
		assertEquals(expected, actual);
	}

	@Test
	public void arrayHasTwoNegativesTest() {
		final int actual = highestProductOf3(new int[] {-10, 1, 3, 2, -10});
		final int expected = 300;
		assertEquals(expected, actual);
	}

	@Test
	public void arrayIsAllNegativesTest() {
		final int actual = highestProductOf3(new int[] {-5, -1, -3, -2});
		final int expected = -6;
		assertEquals(expected, actual);
	}

	@Test
	public void exceptionWithEmptyArrayTest() {
		assertThrows(Exception.class, ()-> {
			highestProductOf3(new int[] {});
		});
	}

	@Test
	public void exceptionWithOneNumberTest() {
		assertThrows(Exception.class, ()-> {
			highestProductOf3(new int[] {1});
		});
	}

	@Test
	public void exceptionWithTwoNumbersTest() {
		assertThrows(Exception.class, ()-> {
			highestProductOf3(new int[] {1, 1});
		});
	}
}
