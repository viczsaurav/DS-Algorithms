package interviewCake;

import java.util.Arrays;
import java.util.Random;

public class InPlaceArrayShuffle {

	/**
	 * The shuffle must be "uniform," meaning each item in the original array must have the
	 * same probability of ending up in each spot in the final array.
	 *
	 * Assume that you have a method getRandom(floor, ceiling) for getting a random integer that is >= floor and <= ceiling.
	 */

	private static Random rand = new Random();

	private static int getRandom(int floor, int ceiling) {
		return rand.nextInt((ceiling - floor) + 1) + floor;
	}

	public static void naiveShuffle(int[] array) {

		// for each index in the array
		for (int firstIndex = 0; firstIndex < array.length; firstIndex++) {

			// grab a random other index
			int secondIndex = getRandom(0, array.length - 1);

			// and swap the values
			if (secondIndex != firstIndex) {
				int temp = array[firstIndex];
				array[firstIndex] = array[secondIndex];
				array[secondIndex] = temp;
			}
		}
	}

	public static void shuffle(int[] array) {

		// if it's 1 or 0 items, just return
		if (array.length <= 1) {
			return;
		}

		// walk through from beginning to end
		for (int firstIndex = 0; firstIndex < array.length - 1; firstIndex++) {

			// choose a random not-yet-placed item to place there
			// (could also be the item currently in that spot)
			// must be an item AFTER the current item, because the stuff
			// before has all already been placed
			int secondIndex = getRandom(firstIndex, array.length - 1);

			// place our random choice in the spot by swapping
			if (secondIndex != firstIndex) {
				int temp = array[firstIndex];
				array[firstIndex] = array[secondIndex];
				array[secondIndex] = temp;
			}
		}
	}


	public static void main(String[] args) {
		final int[] initial = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		final int[] shuffled = Arrays.copyOf(initial, initial.length);
		shuffle(shuffled);
		System.out.printf("initial array: %s\n", Arrays.toString(initial));
		System.out.printf("shuffled array: %s\n", Arrays.toString(shuffled));
	}


}
