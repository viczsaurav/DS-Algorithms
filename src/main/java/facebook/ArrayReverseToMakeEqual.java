package facebook;

// Add any extra import statements you may need here

public class ArrayReverseToMakeEqual {

	/**
	 * Given two arrays A and B of length N, determine if there is a way to make A equal to B by reversing any subarrays from array B any number of times.
	 * Signaturec: bool areTheyEqual(int[] arr_a, int[] arr_b)
	 * Input
	 * 	All integers in array are in the range [0, 1,000,000,000].
	 * Output
	 * 	Return true if B can be made equal to A, return false otherwise.
	 * Example
	 * 	A = [1, 2, 3, 4]
	 * 	B = [1, 4, 3, 2]
	 * output = true
	 * 	After reversing the subarray of B from indices 1 to 3, array B will equal array A.
	 */

	boolean areTheyEqual(int[] array_a, int[] array_b) {

		if (array_a.length!= array_b.length)  return false;

		int i=0, j=0;

		while(i<array_a.length && j<array_b.length){
			int temp_i=0, temp_j=0;

			if(array_a[i]== array_b[j]){
				i++; j++;
			}
			else {
				temp_i=i; temp_j=j;
				while (temp_j<array_b.length-1 && array_b[temp_j]!=array_a[i] ){
					temp_j++;
				}
				j= temp_j;
				while(temp_i<=j && temp_j>= i){
					if (array_b[temp_j]==array_a[temp_i]) {
						temp_j--; temp_i++;
					}
					else return false;
				} //while
				i=temp_i;
			} //else
		}
		return true;

	}


	// These are the tests we use to determine if the solution is correct.
	// You can add your own at the bottom, but they are otherwise not editable!
	int test_case_number = 1;
	void check(boolean expected, boolean output) {
		boolean result = (expected == output);
		char rightTick = '\u2713';
		char wrongTick = '\u2717';
		if (result) {
			System.out.println(rightTick + " Test #" + test_case_number);
		}
		else {
			System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
			System.out.print(expected);
			System.out.print(" Your output: ");
			System.out.print(output);
			System.out.println();
		}
		test_case_number++;
	}
	void printString(String str) {
		System.out.print("[" + str + "]");
	}

	public void run() {
		int[] array_a_1 = {1, 2, 3, 4};
		int[] array_b_1 = {1, 4, 3, 2};
		boolean expected_1 = true;
		boolean output_1 = areTheyEqual(array_a_1, array_b_1);
		check(expected_1, output_1);

		int[] array_a_2 = {1, 2, 3, 4};
		int[] array_b_2 = {1, 4, 3, 3};
		boolean expected_2 = false;
		boolean output_2 = areTheyEqual(array_a_2, array_b_2);
		check(expected_2, output_2);
		// Add your own test cases here

		int[] array_a_3 = {1, 2, 3, 4, 5, 7, 8, 9};
		int[] array_b_3 = {1, 4, 3, 2, 5, 8, 7, 9};
		boolean expected_3 = true;
		boolean output_3 = areTheyEqual(array_a_3, array_b_3);
		check(expected_3, output_3);

		int[] array_a_4 = {1, 2, 3, 4, 5, 7, 8, 9};
		int[] array_b_4 = {1, 4, 3, 2, 5, 8, 7, 5};
		boolean expected_4 = false;
		boolean output_4 = areTheyEqual(array_a_4, array_b_4);
		check(expected_4, output_4);

	}

	public static void main(String[] args) {
		new ArrayReverseToMakeEqual().run();
	}
}