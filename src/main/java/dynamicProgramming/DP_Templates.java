package dynamicProgramming;

public class DP_Templates {

    /**
     * Example - house robber -  https://youtu.be/ZwDDLAeeBM0?t=483
     * @param nums
     * @return
     */
    int decisionTemplate(int[] nums){
        // base condition
        if (nums.length==0) return 0;

        int dp[] = new int[nums.length+1]; // always 1 more than source array

        // Set initial values
        dp[0] = 0;
        dp[1]= nums[0];

        for (int i=1; i<nums.length;i++){
            dp[i+1] = 0; // Max condition for calculation
        }
        return dp[nums.length]; // last element will always give you max of whole array
    }
}
