package interviewCake;

import org.junit.jupiter.api.Test;

import static interviewCake.RotationPoint.findRotationPoint;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRotationPoint {

	// tests

	@Test
	public void smallArrayTest() {
		final int actual = findRotationPoint(new String[] {"cape", "cake"});
		final int expected = 1;
		assertEquals(expected, actual);
	}

	@Test
	public void mediumArrayTest() {
		final int actual = findRotationPoint(new String[] {"grape", "orange", "plum",
						"radish", "apple"});
		final int expected = 4;
		assertEquals(expected, actual);
	}

	@Test
	public void largeArrayTest() {
		final int actual = findRotationPoint(
						new String[] {"ptolemaic", "retrograde", "supplant", "undulate", "xenoepist",
										"asymptote", "babka", "banoffee", "engender", "karpatka", "othellolagkage"});
		final int expected = 5;
		assertEquals(expected, actual);
	}

	@Test
	public void possiblyMissingEdgeCaseTest() {
		// are we missing any edge cases?
	}
}
