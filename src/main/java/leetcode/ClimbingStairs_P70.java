package leetcode;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs_P70 {
    /**
     * **Dynamic Programming**
     * You are climbing a stair case. It takes n steps to reach to the top.
     * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
     *
     *
     * Solution Approach:
     * Let number of ways to reach nth Stair be f(n)
     * You can either reach nth stair from :
     *  - (n-1)th stair with 1 step
     *  - (n-2)th stair with 2 steps
     *
     *  thus, f(n) = f(n-1) + f(n-2) [from def of f(n)]
     *  similarly, f(n-1) = f((n-1)-1) + f((n-1)-2) => f(n-2) + f(n-3)..
     *  and f(1) = 1 [only 1 way to reach 1st Step]
     *  and f(2) = 2 [ 2 ways to reach => {2 (1) steps, 1 (2) step}]
     *
     *  After this similar to Fibonacci
     */

    Map<Integer, Integer> stepCount = new HashMap<>();
    public int climbStairs(int n) {
        // Edge cases
        if (n<=0) return 0;

        // Base condition
        if(n==1) return 1;
        if(n==2) return 2;

        if (stepCount.containsKey(n)){
            return stepCount.get(n);
        }

        int sum = climbStairs(n-1) + climbStairs(n-2);
        stepCount.put(n, sum);
        return sum;
    }


}
