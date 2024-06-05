package leetcode;
import java.util.*;

class LongestArithmeticSubsequence {
    public int longestArithSeqLength(int[] nums) {

        // Define Array of type Map(like a 2d array)
        // int [] dp =  new int[size]
        Map<Integer, Integer> [] dp =  new HashMap[nums.length];
        int max = 0;

        for (int i=0; i< nums.length;i++){
            // Initialize each Map entry
            dp[i] = new HashMap<>();
            for(int j=0;j<i;j++){
                int diff = nums[j] - nums[i];
                // add (k,v) for each index
                // where k= diff of value at i and all elements before it
                // and v = number of times, this diff is seen.
                dp[i].put(diff,dp[j].getOrDefault(diff,1)+1);
                max = Math.max(max, dp[i].get(diff));
            }
        }
        return max;
    }
}