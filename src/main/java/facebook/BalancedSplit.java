package facebook;
import java.util.*;


class BalancedSplit {

	/**
	 * Time : O(NlogN), Space: O(1)

	 */
	boolean balancedSplitExists(int[] arr) {
		// One way - NlogN approach
		Arrays.sort(arr);
		int i=0,j=arr.length-1;
		int leftSum=arr[i];
		int rightSum=arr[j];
		int maxLeft=arr[i];
		int minRight= arr[j];

		while(i<j){

			if (leftSum==rightSum) {
				i++; j--;
				if (i<j)  {
					leftSum += arr[i];
					rightSum += arr[j];
					maxLeft = Math.max(maxLeft, arr[i]);
					minRight = Math.min(minRight, arr[i]);
				}
			}
			else if (leftSum< rightSum) {
				i++;
				leftSum += arr[i];
				maxLeft = Math.max(maxLeft, arr[i]);
			}
			else {
				j++;
				rightSum += arr[j];

			}
		}

		if (leftSum==rightSum && maxLeft < minRight) return true;
		else return false;


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
		int arr_1[] = {2, 1, 2, 5};
		boolean expected_1 = true;
		boolean output_1 = balancedSplitExists(arr_1);
		check(expected_1, output_1);

		int arr_2[] = {3, 6, 3, 4, 4};
		boolean expected_2 = false;
		boolean output_2 = balancedSplitExists(arr_2);
		check(expected_2, output_2);

		// Add your own test cases here

	}

	public static void main(String[] args) {
		new BalancedSplit().run();
	}
}