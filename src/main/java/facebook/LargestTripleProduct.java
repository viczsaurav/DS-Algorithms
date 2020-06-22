package facebook;

import java.util.*;

public class LargestTripleProduct {

	/**
	 * https://www.facebookrecruiting.com/portal/coding_practice_question/?problem_id=510655302929581
	 *
	 * Largest Triple Products
	 * You're given a list of n integers arr[0..(n-1)]. You must compute a list output[0..(n-1)] such that, for each index i (between 0 and n-1, inclusive), output[i] is equal to the product of the three largest elements out of arr[0..i] (or equal to -1 if i < 2, as arr[0..i] then includes fewer than three elements).
	 *
	 * Note that the three largest elements used to form any product may have the same values as one another, but they must be at different indices in arr.
	 * Signature :  int[] findMaxProduct(int[] arr)
	 * Input:
	 * 	 - n is in the range [1, 100,000].
	 *   - Each value arr[i] is in the range [1, 1,000].
	 * Output
	 * 	 - Return a list of n integers output[0..(n-1)], as described above.
	 */

	/**
	 * Time: O(N), Space: O(1)
	 *
	 */

	int[] findMaxProduct(int[] arr) {
		// Array values cant be negative
		// Check array length - edge conditions
		int[] out = new int[arr.length];
		List<Integer> prodList = new ArrayList<>();
		for(int i=0;i<3;i++){
			prodList.add(arr[i]);
		}

		int maxProduct = arr[2] * arr[1] * arr[0];
		int minVal = Collections.min(prodList);
		out[0] = out[1] = -1;
		out[2] = maxProduct;

		for (int i=3; i< arr.length; i++){
			int curr = arr[i];
			int currProd = (maxProduct/minVal) * curr;

			if (currProd>maxProduct){
				out[i] = currProd;
				maxProduct = currProd;
				prodList.remove(new Integer(minVal));		// https://www.geeksforgeeks.org/remove-element-arraylist-java/
				prodList.add(new Integer(curr));
				minVal= Collections.min(prodList);
			}
			else {
				out[i] = maxProduct;
			}
		}
		return out;

	}



	int test_case_number = 1;

	void check(int[] expected, int[] output) {
		int expected_size = expected.length;
		int output_size = output.length;
		boolean result = true;
		if (expected_size != output_size) {
			result = false;
		}
		for (int i = 0; i < Math.min(expected_size, output_size); i++) {
			result &= (output[i] == expected[i]);
		}
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		}
		else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			printIntegerArray(expected);
			System.out.print(" Your output: ");
			printIntegerArray(output);
			System.out.println();
		}
		test_case_number++;
	}

	void printIntegerArray(int[] arr) {
		int len = arr.length;
		System.out.print("[");
		for(int i = 0; i < len; i++) {
			if (i != 0) {
				System.out.print(", ");
			}
			System.out.print(arr[i]);
		}
		System.out.print("]");
	}

	public void run() {
		int[] arr_1 = {1, 2, 3, 4, 5};
		int[] expected_1 = {-1, -1, 6, 24, 60};
		int[] output_1 = findMaxProduct(arr_1);
		check(expected_1, output_1);

		int[] arr_2 = {2, 4, 7, 1, 5, 3};
		int[] expected_2 = {-1, -1, 56, 56, 140, 140};
		int[] output_2 = findMaxProduct(arr_2);
		check(expected_2, output_2);


	}

	public static void main(String[] args) {
		new LargestTripleProduct().run();
	}
}
