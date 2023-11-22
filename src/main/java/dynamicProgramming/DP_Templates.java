package dynamicProgramming;

public class DP_Templates {

    /**
     *1. Write objective function - F(i) => Cost to get to ith stair
     *2. Identify Base cases => F(0) = 10, F(1) = 15, F(2) = 15
     *3. Define Transition Function
     - Imagine you have already completed/ solved - End of the problem
     - Imagine you are already crossed. F(n)
     F(n) = cost[n] + min(F(n-1), F(n-2))
     4. Bottom Up -> Starting from base case and getting final result
     5. What gives you result - min(F(n-1), F(n-2))
     */

    int decisionTemplate(int[] nums){
        // base condition
        if (nums.length==0) return 0;

        int dp[] = new int[nums.length+1]; // always 1 more than source array

        // Set initial values
        dp[0] = 0;
        dp[1]= nums[0];

        for (int i=1; i<nums.length;i++){
            dp[i+1] = 0; // Max condition for calculation/ Transition Function
        }
        return dp[nums.length]; // last element will always give you max of whole array
    }
}
