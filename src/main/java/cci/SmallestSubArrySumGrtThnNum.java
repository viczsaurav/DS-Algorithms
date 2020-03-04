package cci;

/**
 * Problem:  Find smallest subarray  with sum greater than a given value (positive numbers)
 *  
 * @author Saurav
 *
 */
public class SmallestSubArrySumGrtThnNum {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int [] arry1 = {1,4,45,6,0,19};
		int n1 = 74;
		System.out.println("Length1-N   : "+ findSmallestSubArryN(arry1,n1));
		System.out.println("Length1-N^2 : "+ findSmallestSubArryN2(arry1,n1)+"\n");
		
		int [] arry2 = {1,10,5,2,7};
		int n2 = 70;
		System.out.println("Length2-N   : "+ findSmallestSubArryN(arry2,n2));
		System.out.println("Length2-N^2 : "+ findSmallestSubArryN2(arry2,n2)+"\n");
		
		int [] arry3 = {1,10,3,40,18};
		int n3 = 50;
		System.out.println("Length3-N   : "+ findSmallestSubArryN(arry3,n3));
		System.out.println("Length3-N^2 : "+ findSmallestSubArryN2(arry3,n3)+"\n");

		int [] arry4 = {1,10,3,40,18,3,50};
		int n4 = 48;
		System.out.println("Length4-N   : "+ findSmallestSubArryN(arry4,n4));
		System.out.println("Length4-N^2 : "+ findSmallestSubArryN2(arry4,n4)+"\n");
		CommonUtils.displayExecutionTime(startTime);
	}

	/**
	 * Finding smallest subarray in Quadratic time - O(n^2) 
	 * @param arr
	 * @param n
	 * @return
	 */
	private static int findSmallestSubArryN2(int[] arr, int n) {
		int size = arr.length;
		int minLength=	size + 1;		// Smallest Subarray size
		
		for (int start=0; start<size;start++) {
			
			int currSum=arr[start];
			
			if(currSum>n) 	return 1; 		// 1st field
			
			for (int end=start+1;end<size;end++) {
				currSum+= arr[end];		//Keep Adding next elements to current sum
				if (currSum> n && (end-start+1) < minLength) 
				{
					minLength = end-start+1;
				}
				if ((end-start+1) == size && currSum < n) return 0;			// No Subarray
			}
		}
		return minLength;
	}

	/**
	 * Finding smallest subarray in Linear time - O(2n)=~ O(n)
	 * @param arr
	 * @param n
	 * @return
	 */
	private static int findSmallestSubArryN(int[] arr, int n) {
		int size = arr.length;
		int minLength=	size + 1;		// Smallest Subarray size
		
		int start=0,end=0;
		int currSum=0;
		
		while  (end < size) {
			// Sum elements till sum > n
			while(currSum<n && end < size) {
				currSum+=arr[end++];
			}
			
			if ((end-start) == size && currSum < n) return 0;			// No Subarray
			
			while(currSum>n && start< end) {
				if (end-start <minLength) {			// no end-start+1 as end++ already has end value as end+1
					minLength = end-start;
				}
				currSum -= arr[start++];		
			}
		}
		return minLength;
	}

}
