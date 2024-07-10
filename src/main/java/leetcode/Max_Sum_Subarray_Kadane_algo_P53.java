package leetcode;

public class Maximum_Subarray_Kadane_algo_P53 {
    public int maxSubArray(int[] nums) {

        int currMax = nums[0];
        int maxSum = nums[0];

        //Kadane's Algo
        for(int i=1; i<nums.length;i++){
            currMax = Math.max(currMax + nums[i], nums[i]);
            maxSum = Math.max(maxSum, currMax);
        }
        return maxSum;
    }
}
