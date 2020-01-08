package cci;

/**
 * Cracking Coding Interview 
 * ----------------------------
 * Page-52 : A sorted array has been rotated so that the elements might appear in the order 3456712. 
 * How would you find the minimum element? You may assume that the array has all unique elements.
 * 
 * Sol : Find the pivot point, divide the array in two sub-arrays and call binary search.
	The main idea for finding pivot is – for a sorted (in increasing order) and pivoted array, 
	pivot element is the only only element for which next element to it is smaller than it.
	Using above criteria and binary search methodology we can get pivot element in O(logn) time
	
 * @author Saurav	
 */

public class RotatingArray {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		// int [] arr = {3,4,5,6,1,2};
		// int [] arr = {3,4,5,6,1,2};
		int[] arr = { 0, 1, 2, 3, 4, 5, 6 };
		int[] arr1 = { 6, 7, 1, 2, 3, 4, 5 };
		minValueInRotatedArray(arr, 0, arr.length - 1);
		minValueInRotatedArray(arr1, 0, arr1.length - 1);
		CommonUtils.displayExecutionTime(startTime);
	}
	
	
	public static void minValueInRotatedArray(int[] arr, int low, int high) {
		int mid = (low + high) / 2;
		if ((arr[mid] < arr[high]))
			minValueInRotatedArray(arr, low, mid);
		else if (arr[mid] > arr[high])
			minValueInRotatedArray(arr, mid + 1, high);
		else
			System.out.println("Lowest Value is : " + arr[mid] + " at index : "
					+ mid);
	}
}
