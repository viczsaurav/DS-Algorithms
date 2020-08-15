package leetcode;

public class HouseRobber_Cyclic_P213 {

    public static int rob(int[] nums) {
        // base case
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        //calculate max for 2 scenarios of cyclic:
        // since 1 & n can't be together, possible solutions:
        // [1, n-1] or [2, n]
        // Solve for both

        // from 1 to n-1
        int[] dp1 = new int[nums.length];
        dp1[0] = 0;
        dp1[1] = nums[0];   // start from first element

        for (int i = 1; i < nums.length - 1; i++) {
            dp1[i + 1] = Math.max(dp1[i], nums[i] + dp1[i - 1]);
        }

        // from 2 to n
        int[] dp2 = new int[nums.length];
        dp2[0] = 0;
        dp2[1] = nums[1];   // start from 2nd element

        for (int i = 2; i < nums.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], nums[i] + dp2[i - 2]);
        }

        // System.out.println("dp1 <=> dp2");
        // for (int i=0; i<dp2.length;i++){
        //     System.out.println(dp1[i]+ " <=> "+ dp2[i]);
        // }

        return Math.max(dp1[nums.length - 1], dp2[nums.length - 1]);
    }

    public static void main(String[] args) {
        int[] input1 = {2,3,2};
        System.out.println("Expected: 3, Actual: "+ rob(input1));

        int[] input2 = {1,2,3,1};
        System.out.println("Expected: 4, Actual: "+ rob(input2));
    }
}
