package searchingAndSorting;

public class BinarySearch {

	/**
	 * Careful: we can only use binary search if the input array is ALREADY sorted.
	 *
	 */

	public static boolean binarySearch(int target, int[] nums) {

		int start =0;
		int end = nums.length;

		while (start<end){
			int mid = (end+start)/2;

			if (target==nums[mid])	{
				System.out.println("Match found at index: "+ mid);
				return true;
			}
			else if (target > nums[mid])
				start = mid+1;
			else
				end = mid-1;
		}
		return false;
	}

	public static boolean binarySearchRecursive(int target, int[] nums, int start, int end) {

		while (start<end){
			int mid = (end+start)/2;

			if (target==nums[mid])	{
				System.out.println("Match found at index: "+ mid);
				return true;
			}
			else if (target > nums[mid])
				return binarySearchRecursive(target,nums, mid+1, end);
			else
				return binarySearchRecursive(target,nums, start,mid-1);
		}
		return false;
	}

	public static void main(String[] args) {
		final int target = 43;
		final int[] nums = {17, 21, 32, 44, 51, 69, 73, 83, 92, 103};
		System.out.println(binarySearch(target, nums));
		System.out.println(binarySearchRecursive(target,nums, 0, nums.length));
	}
}
