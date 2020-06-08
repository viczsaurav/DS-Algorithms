package leetcode;

public class MedianSortedArrays_P4 {

	/**
	 * Time Complexity : O(m+n)
	 * Space Complexity: O(m+n)
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int i=0,j=0,k=0;
		int[] merged = new int[nums1.length + nums2.length];

		while(i<nums1.length || j<nums2.length){
			if(i<nums1.length && j<nums2.length){
				if(nums1[i]<nums2[j]){
					merged[k]=  nums1[i];
					k++; i++;
				}
				else {
					merged[k]=  nums2[j];
					k++; j++;
				}
			}
			else if (i<nums1.length){
				merged[k]=  nums1[i];
				k++; i++;
			}
			else if (j<nums2.length){
				merged[k]=  nums2[j];
				k++; j++;
			}
		}
		return getMedian(merged);
	}

	private double getMedian(int[] merged){
		double median=0;
		int length = merged.length;
		if (length%2==0){
			median = (merged[(length/2)-1]+ merged[length/2])/2.0;
		}
		else {
			median = merged[length/2];
		}
		return median;
	}

	/**
	 * https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch/MedianOfTwoSortedArrayOfDifferentLength.java
	 *
	 * time complexity should be O(log (m+n)).
	 *
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public static double MedianSortedArraysForDifferentLengths(int[] nums1, int[] nums2) {

		if (nums1.length>nums2.length){
			return MedianSortedArraysForDifferentLengths(nums2,nums1);
		}

		// Binary Search on smaller array
		int x = nums1.length;
		int y = nums2.length;

		int start=0;
		int end=x;

		while(start<=end){
			// This decides that the combined length of left and right partitions of nums1 and nums2 are equal
			int partX = (start+end)/2;
			int partY = (x+y+1)/2 - partX;

			int maxLeftX = (partX==0)? Integer.MIN_VALUE:nums1[partX - 1];
			int minRightX = (partX==x)? Integer.MAX_VALUE:nums1[partX];

			int maxLeftY = (partY==0)? Integer.MIN_VALUE:nums2[partY - 1];
			int minRightY = (partY==y)? Integer.MAX_VALUE:nums2[partY];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX){
				//We have partitioned array at correct place
				// Now get max of left elements and min of right elements to get the median in case of even length combined array size
				// or get max of left for odd length combined array size.
				if ((x+y)%2==0)	return ((Math.max(maxLeftX,maxLeftY) + Math.min(minRightX, minRightY))/2.0);
				else	return (double) Math.max(maxLeftX,maxLeftY);
			}
			else if (maxLeftX > minRightY){
				end=partX - 1;
			}
			else {
				start=partX + 1;
			}
		}
		throw new IllegalArgumentException("Not sorted");
	}

	public static void main(String[] args) {
		int[] nums1 = {1,3,8,9,15};
		int[] nums2 = {7,11,19,21,23,25};

		System.out.println(MedianSortedArraysForDifferentLengths(nums1,nums2));

		int [] nums3 = {23,26,31,35};
		int [] nums4 = {73,5,7,9,11,16};

		System.out.println(MedianSortedArraysForDifferentLengths(nums4,nums3));
	}
}

