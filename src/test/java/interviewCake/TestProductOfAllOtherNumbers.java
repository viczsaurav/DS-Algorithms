package interviewCake;

import org.junit.jupiter.api.Test;

import static interviewCake.ProductOfAllOtherNumbers.getProductsOfAllIntsExceptAtIndex;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestProductOfAllOtherNumbers {

	// tests

	@Test
	public void smallArrayTest() {
		final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {1, 2, 3});
		final int[] expected = new int[] {6, 3, 2};
		assertArrayEquals(expected, actual);
	}

	@Test
	public void longArrayTest() {
		final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {8, 2, 4, 3, 1, 5});
		final int[] expected = new int[] {120, 480, 240, 320, 960, 192};
		assertArrayEquals(expected, actual);
	}

	@Test
	public void arrayHasOneZeroTest() {
		final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {6, 2, 0, 3});
		final int[] expected = new int[] {0, 0, 36, 0};
		assertArrayEquals(expected, actual);
	}

	@Test
	public void arrayHasTwoZerosTest() {
		final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {4, 0, 9, 1, 0});
		final int[] expected = new int[] {0, 0, 0, 0, 0};
		assertArrayEquals(expected, actual);
	}

	@Test
	public void oneNegativeNumberTest() {
		final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {-3, 8, 4});
		final int[] expected = new int[] {32, -12, -24};
		assertArrayEquals(expected, actual);
	}

	@Test
	public void allNegativeNumbersTest() {
		final int[] actual = getProductsOfAllIntsExceptAtIndex(new int[] {-7, -1, -4, -2});
		final int[] expected = new int[] {-8, -56, -14, -28};
		assertArrayEquals(expected, actual);
	}

	@Test
	public void exceptionWithEmptyArrayTest() {
		assertThrows(Exception.class, ()-> {
			getProductsOfAllIntsExceptAtIndex(new int[] {});
		});
	}

	@Test
	public void exceptionWithOneNumberTest() {
		assertThrows(Exception.class,()->{
			getProductsOfAllIntsExceptAtIndex(new int[] {1});
		});
	}
}
