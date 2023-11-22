package leetcode;

public class DP_MinCostClimbingStairs_P746 {

        public int minCostClimbingStairs(int[] cost) {
        /*
        1. Write objective function - F(i) => Cost to get to ith stair
        2. Identify Base cases => F(0) = 10, F(1) = 15, F(2) = 15
        3. Define Transition Function
            - Imagine you have already completed/ solved - End of the problem
            - Imagine you are already crossed. F(n)
            F(n) = cost[n] + min(F(n-1), F(n-2))
        4. Bottom Up -> Starting from base case and getting final result
        5. What gives you result - min(F(n-1), F(n-2))

        0, 1,  2,3,4, 5, 6,7, 8, 9
        1,100, 1,1,1,100,1,1,100,1
        1,100, 2,3,3,

        */
            int prevStepCost = cost[0];
            int currStepCost = cost[1];
            int finalCost = 0;

            for (int i=2; i < cost.length;i++){
                finalCost =  cost[i] + Math.min(currStepCost, prevStepCost);
                prevStepCost = currStepCost;
                currStepCost = finalCost;
            }
            return Math.min(prevStepCost,currStepCost );
        }
}
