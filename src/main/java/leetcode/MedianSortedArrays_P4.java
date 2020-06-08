package leetcode;

public class MedianSortedArrays_P4 {

	/*
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
}

