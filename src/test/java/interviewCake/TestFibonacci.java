package interviewCake;

import org.junit.jupiter.api.Test;

import static interviewCake.Fibonacci.fib;
import static interviewCake.Fibonacci.fibRecurse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestFibonacci {
	// tests

	@Test
	public void zerothFibonacciTest() {
		final int recurse = fibRecurse(0);
		final int actual = fib(0);
		final int expected = 0;
		assertEquals(expected, recurse);
		assertEquals(expected, actual);
	}

	@Test
	public void firstFibonacciTest() {
		final int recurse = fibRecurse(1);
		final int actual = fib(1);
		final int expected = 1;
		assertEquals(expected, recurse);
		assertEquals(expected, actual);
	}

	@Test
	public void secondFibonacciTest() {
		final int recurse = fibRecurse(2);
		final int actual = fib(2);
		final int expected = 1;
		assertEquals(expected, recurse);
		assertEquals(expected, actual);
	}

	@Test
	public void thirdFibonacciTest() {
		final int recurse = fibRecurse(3);
		final int actual = fib(3);
		final int expected = 2;
		assertEquals(expected, recurse);
		assertEquals(expected, actual);
	}

	@Test
	public void fifthFibonacciTest() {
		final int recurse = fibRecurse(5);
		final int actual = fib(5);
		final int expected = 5;
		assertEquals(expected, recurse);
		assertEquals(expected, actual);
	}

	@Test
	public void tenthFibonacciTest() {
		final int recurse = fibRecurse(10);
		final int actual = fib(10);
		final int expected = 55;
		assertEquals(expected, recurse);
		assertEquals(expected, actual);
	}

	@Test
	public void negativeFibonacciTest() {
		assertThrows(Exception.class, ()-> {
			fib(-1);
		});
	}

	@Test
	public void negativeFibonacciRecurseTest() {
		assertThrows(Exception.class, ()-> {
			fibRecurse(-1);
		});
	}
}
