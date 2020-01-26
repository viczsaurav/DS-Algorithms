package interviewCake;

public class HighestProductOf3 {
	/**
	 * Given an array of integers, find the highest product you can get from three of the integers.
	 *
	 * The input arrayOfInts will always have at least three integers.
	 *
	 * Gotchas
	 * Does your method work with negative numbers? If arrayOfInts is [-10, -10, 1, 3, 2][−10,−10,1,3,2] we should return 300300 (which we get by taking -10 * -10 * 3−10∗−10∗3).
	 *
	 * We can do this in O(n)O(n) time and O(1)O(1) space.
	 * @param intArray
	 * @return
	 */
	public static int highestProductOf3(int[] intArray) {

		if (intArray.length <3)
			throw new IllegalArgumentException("Atleast 3 items required.");

		int lowest = Math.min(intArray[0], intArray[1]);
		int highest = Math.max(intArray[0], intArray[1]);
		int highestProductOf2 = intArray[0] * intArray[1];
		int lowestProductOf2 =  intArray[0] * intArray[1];
		int highestProductOf3 = Integer.MIN_VALUE;


		for(int i=2;i<intArray.length;i++){
			int current = intArray[i];

			//Update highestProductOf3
			highestProductOf3 = Math.max(
							highestProductOf3,
							Math.max(current * highestProductOf2,
											current * lowestProductOf2)
			);

			highestProductOf2 = Math.max(
							highestProductOf2,
							Math.max(current * highest,
											current * lowest)
			);

			lowestProductOf2 = Math.min(
							lowestProductOf2,
							Math.min(current * highest,
											current * lowest)
			);

			highest = Math.max(current, highest);
			lowest = Math.min(current, lowest);

		}

		return highestProductOf3;
	}
}
