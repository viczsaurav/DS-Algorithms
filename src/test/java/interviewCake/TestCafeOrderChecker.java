package interviewCake;

import org.junit.jupiter.api.Test;

import static interviewCake.CafeOrderChecker.isFirstComeFirstServed;
import static org.junit.jupiter.api.Assertions.*;

public class TestCafeOrderChecker {

	// tests

	@Test
	public void bothRegistersHaveSameNumberOfOrdersTest() {
		final int[] takeOutOrders = {1, 4, 5};
		final int[] dineInOrders = {2, 3, 6};
		final int[] servedOrders = {1, 2, 3, 4, 5, 6};
		final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
		assertTrue(result);
	}

	@Test
	public void registersHaveDifferentLengthsTest() {
		final int[] takeOutOrders = {1, 5};
		final int[] dineInOrders = {2, 3, 6};
		final int[] servedOrders = {1, 2, 6, 3, 5};
		final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
		assertFalse(result);
	}

	@Test
	public void oneRegisterIsEmptyTest() {
		final int[] takeOutOrders = {};
		final int[] dineInOrders = {2, 3, 6};
		final int[] servedOrders = {2, 3, 6};
		final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
		assertTrue(result);
	}

	@Test
	public void servedOrdersIsMissingOrdersTest() {
		final int[] takeOutOrders = {1, 5};
		final int[] dineInOrders = {2, 3, 6};
		final int[] servedOrders = {1, 6, 3, 5};
		final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
		assertFalse(result);
	}

	@Test
	public void servedOrdersHasExtraOrders() {
		final int[] takeOutOrders = {1, 5};
		final int[] dineInOrders = {2, 3, 6};
		final int[] servedOrders = {1, 2, 3, 5, 6, 8};
		final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
		assertFalse(result);
	}

	@Test
	public void oneRegisterHasExtraOrders() {
		final int[] takeOutOrders = {1, 9};
		final int[] dineInOrders = {7, 8};
		final int[] servedOrders = {1, 7, 8};
		final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
		assertFalse(result);
	}

	@Test
	public void oneRegisterHasUnservedOrders() {
		final int[] takeOutOrders = {55, 9};
		final int[] dineInOrders = {7, 8};
		final int[] servedOrders = {1, 7, 8, 9};
		final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
		assertFalse(result);
	}
}

