package com.cci;

/*
 * Page-52 : A sorted array has been rotated so that the elements might appear in the order 3456712. 
 * How would you find the minimum element? You may assume that the array has all unique elements.
 * 
 * Sol : Binary Search
 */

public class RotatingArray {
	static final long startTime = System.currentTimeMillis();

	public void minValueInRotatedArray(int[] arr, int low, int high) {
		int mid = (low + high) / 2;
		if ((arr[mid] < arr[high]))
			this.minValueInRotatedArray(arr, low, mid);
		else if (arr[mid] > arr[high])
			this.minValueInRotatedArray(arr, mid + 1, high);
		else
			System.out.println("Lowest Value is : " + arr[mid] + " at index : "
					+ mid);
	}

	private void displayExecutionTime() {
		long finishTime = System.currentTimeMillis();
		double elapsedTime = (finishTime - startTime) / 100;
		System.out.println("\nExcecution time : " + elapsedTime + " seconds");
	}

	public static void main(String[] args) {
		RotatingArray t = new RotatingArray();
		// int [] arr = {3,4,5,6,1,2};
		// int [] arr = {3,4,5,6,1,2};
		int[] arr = { 0, 1, 2, 3, 4, 5, 6 };
		int[] arr1 = { 6, 7, 1, 2, 3, 4, 5 };
		t.minValueInRotatedArray(arr, 0, arr.length - 1);
		t.minValueInRotatedArray(arr1, 0, arr1.length - 1);
		t.displayExecutionTime();
	}
}
