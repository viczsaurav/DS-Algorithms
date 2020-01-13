package interviewCake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeCookies {
	/**
	 * In order to win the prize for most cookies sold, my friend Alice and I are going to merge our Girl Scout Cookies orders and enter as one unit.
	 * <p>
	 * Each order is represented by an "order id" (an integer).
	 * <p>
	 * We have our lists of orders sorted numerically already, in arrays. Write a method to merge our arrays of orders into one sorted array.
	 * <p>
	 * For example:
	 * <p>
	 * int[] myArray = new int[]{3, 4, 6, 10, 11, 15};
	 * int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};
	 * <p>
	 * System.out.println(Arrays.toString(mergeArrays(myArray, alicesArray)));
	 * // prints [1, 3, 4, 5, 6, 8, 10, 11, 12, 14, 15, 19]
	 */

	public static int[] mergeArraysRepeated(int[] myArray, int[] alicesArray) {

		int[] mergedArray = new int[myArray.length + alicesArray.length];

		int myArrayIdx = 0;
		int alicesArrayIdx = 0;
		int mergedArrayIdx = 0;

		while (mergedArrayIdx < mergedArray.length) {
			if (myArrayIdx >= myArray.length) {
				mergedArray[mergedArrayIdx] = alicesArray[alicesArrayIdx];
				alicesArrayIdx++;
			} else if (alicesArrayIdx >= alicesArray.length) {
				mergedArray[mergedArrayIdx] = myArray[myArrayIdx];
				myArrayIdx++;
			} else if (myArray[myArrayIdx] <= alicesArray[alicesArrayIdx]) {
				mergedArray[mergedArrayIdx] = myArray[myArrayIdx];
				myArrayIdx++;
			} else {
				mergedArray[mergedArrayIdx] = alicesArray[alicesArrayIdx];
				alicesArrayIdx++;
			}
			mergedArrayIdx++;
		}
		return mergedArray;
	}

	public static int[] mergeArrays(int[] myArray, int[] alicesArray) {

		int[] mergedArray = new int[myArray.length + alicesArray.length];

		int myArrayIdx = 0;
		int alicesArrayIdx = 0;
		int mergedArrayIdx = 0;

		while (mergedArrayIdx < mergedArray.length) {

			boolean isMyArrayCompleted = (myArrayIdx >= myArray.length);
			boolean isAliceArrayCompleted = (alicesArrayIdx >= alicesArray.length);

			if (!isMyArrayCompleted && (isAliceArrayCompleted ||
							(myArray[myArrayIdx] <= alicesArray[alicesArrayIdx]))) {
				mergedArray[mergedArrayIdx] = myArray[myArrayIdx];
				myArrayIdx++;
			} else {
				mergedArray[mergedArrayIdx] = alicesArray[alicesArrayIdx];
				alicesArrayIdx++;
			}
			mergedArrayIdx++;
		}
		return mergedArray;

	}

	/**
	 * What if we wanted to merge several sorted arrays? Write a method that takes as an input an array of sorted arrays and outputs a single sorted array with all the items from each array.
	 *
	 * Do we absolutely have to allocate a new array to use for the merged output? Where else could we store our merged array?
	 * How would our method need to change?
	 */

	public static int[] mergeAllArrays(int[][] arrayOfArrays){

		List<Integer> allMergedArray = new ArrayList<>();

		for (int i=0; i<arrayOfArrays.length;i++){
			// Convert List<Integer> => int[] Array
			int[] toMergeArray = allMergedArray.stream().mapToInt(num-> num).toArray();
			int[] mergedArray = mergeArrays(toMergeArray, arrayOfArrays[i]);

			// Convert int[] Array => List<Integers>
			allMergedArray = Arrays.stream(mergedArray).boxed().collect(Collectors.toList());
		}
		return allMergedArray.stream().mapToInt(num-> num).toArray();
	}
}
