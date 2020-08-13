package leetcode;

public class HouseRobber_P198 {

    /**
     * You are a professional robber planning to rob houses along a street.
     * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them
     * is that adjacent houses have security system connected and it will automatically contact the police
     * if two adjacent houses were broken into on the same night.
     *
     * Given a list of non-negative integers representing the amount of money of each house, determine the maximum
     * amount of money you can rob tonight without alerting the police.
     *
     * https://leetcode.com/problems/house-robber/
     *
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        if(nums.length==0) return 0;

        int dp[] = new int[nums.length+1];
        dp[0]=0;
        dp[1] = nums[0];

        for (int i=1; i<nums.length;i++){
            dp[i+1] = Math.max(dp[i], nums[i]+ dp[i-1]);
            // note: dp[i-1] here is the max till nums[i-2],
            // thus its not adjacent to the old max
            // e.g i=2, dp[3] = Math.max(dp[2], nums[2] + dp[1]);
        }

        return dp[nums.length];
    }
}
