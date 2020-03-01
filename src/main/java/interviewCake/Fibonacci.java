package interviewCake;

import java.util.*;

public class Fibonacci {

	private static Map<Integer, Integer> values = new HashMap<>();

	/**
	 * Recursive approach (Top Down):
	 *
	 * T(n) = T(n-1) + c
	 *      = T(n-2) + 2c
	 *      = T(n-3) + 3c
	 *      = T(n-k) + kc
	 * Let's find the value of k for which: n - k = 0
	 * k = n
	 * T(n) = T(0) + nc
	 *      = nc + 1
	 * i.e. time take by fibonacci recursive with memorization / Dynamic Programming is O(n).
	 *
	 * Space Complexity : O(n)
	 * @param n
	 * @return
	 */
	public static int fibRecurse(int n) {

		if (n<0){
			throw new IllegalArgumentException("Negative value not permitted");
		} else if (n==0 || n==1) {
			return n;
		}

		if(values.containsKey(n)){
			return values.get(n);
		}

		int sum = fibRecurse(n-1) + fibRecurse(n-2);
		values.put(n,sum);
		return sum;
	}

	/**
	 * Iterative Approach (Bottom-up)
	 *
	 * Time complexity : O(n)
	 * Spaace Complexity: O(1)
	 *
	 * @param n
	 * @return
	 */

	public static int fib(int n) {
		if (n<0){
			throw new IllegalArgumentException("Negative value not permitted");
		} else if (n==0 || n==1) {
			return n;
		}

		// we'll be building the fibonacci series from the bottom up
		// so we'll need to track the previous 2 numbers at each step
		int prevPrev = 0;  // 0th fibonacci
		int prev = 1;      // 1st fibonacci
		int sum = 0;   // Declare and initialize current


		for(int i=2; i<=n;i++){

			// Iteration 1: current = 2nd fibonacci
			// Iteration 2: current = 3rd fibonacci
			// Iteration 3: current = 4th fibonacci
			// To get nth fibonacci ... do n-1 iterations.

			sum = prev + prevPrev;
			prevPrev = prev;
			prev = sum;
		}

		return sum;

	}
}
