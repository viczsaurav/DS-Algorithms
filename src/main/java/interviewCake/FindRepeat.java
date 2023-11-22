package interviewCake;

public class FindRepeat {

	/**
	 * Find a duplicate, Space Edition™.
	 *
	 * We have an array of integers, where:
	 *
	 * The integers are in the range 1..n
	 * The array has a length of n+1
	 *
	 * It follows that our array has at least one integer which appears at least twice.
	 * But it may have several duplicates, and each duplicate may appear more than twice.
	 *
	 * Write a method which finds an integer that appears more than once in our array.
	 * (If there are multiple duplicates, you only need to find one of them.)
	 *
	 * We're going to run this method on our new, super-hip MacBook Pro With Retina Display™.
	 * Thing is, the damn thing came with the RAM soldered right to the motherboard, so we can't upgrade our RAM.
	 * So we need to optimize for space! => Preferably O(1)
	 * @param numbers
	 * @return
	 */

	public static int findRepeat(int[] numbers) {

		// find a number that appears more than once
		if (numbers.length < 2) {
			throw new IllegalArgumentException("Finding duplicate requires at least two numbers");
		}
		// O[n] space
		int [] seen = new int[numbers.length];

		for (int n : numbers) {
			if (seen[n] == 1) {
				return n;
			} else {
				seen[n] = 1;
			}
		}
		return 0;
	}
}
