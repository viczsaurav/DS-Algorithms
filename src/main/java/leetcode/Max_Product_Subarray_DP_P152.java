package leetcode;

public class Max_Product_Subarray_DP_P152 {
    public int maxProduct(int[] nums) {

        int ans=nums[0];
        int dpMin = nums[0];
        int dpMax = nums[0];

        for(int i=1;i<nums.length;i++){
            int n = nums[i];
            int prevMin = dpMin; // assign i-1 value
            int prevMax = dpMax;

            if(n<0){
                dpMin = Math.min(prevMax * n, n);
                dpMax = Math.max(prevMin * n, n);
            }
            else {
                dpMin = Math.min(prevMin * n, n);
                dpMax = Math.max(prevMax * n, n);
            }

            ans = Math.max(ans, dpMax);
        }
        return ans;
    }
}
