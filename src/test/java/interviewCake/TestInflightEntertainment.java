package interviewCake;

import org.junit.jupiter.api.Test;

import static interviewCake.InflightEntertainment.canTwoMoviesFillFlight;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestInflightEntertainment {

	// tests

	@Test
	public void shortFlightTest() {
		final boolean result = canTwoMoviesFillFlight(new int[] {2, 4}, 1);
		assertFalse(result);
	}

	@Test
	public void longFlightTest() {
		final boolean result = canTwoMoviesFillFlight(new int[] {2, 4}, 6);
		assertTrue(result);
	}

	@Test
	public void onlyOneMovieHalfFlightLenghtTest() {
		final boolean result = canTwoMoviesFillFlight(new int[] {3, 8}, 6);
		assertFalse(result);
	}

	@Test
	public void twoMoviesHalfFlightLengthTest() {
		final boolean result = canTwoMoviesFillFlight(new int[] {3, 8, 3}, 6);
		assertTrue(result);
	}

	@Test
	public void lotsOfPossiblePairsTest() {
		final boolean result = canTwoMoviesFillFlight(new int[] {1, 2, 3, 4, 5, 6}, 7);
		assertTrue(result);
	}

	@Test
	public void notUsingFirstMovieTest() {
		final boolean result = canTwoMoviesFillFlight(new int[] {4, 3, 2}, 5);
		assertTrue(result);
	}

	@Test
	public void oneMovieTest() {
		final boolean result = canTwoMoviesFillFlight(new int[] {6}, 6);
		assertFalse(result);
	}

	@Test
	public void noMoviesTest() {
		final boolean result = canTwoMoviesFillFlight(new int[] {}, 6);
		assertFalse(result);
	}
}
