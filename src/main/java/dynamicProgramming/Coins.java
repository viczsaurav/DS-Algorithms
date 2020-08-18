package dynamicProgramming;

import java.util.Arrays;

public class Coins {

	int[] maxValues;

	public Coins(int n){
		maxValues = new int[n+1];
		Arrays.fill(maxValues, -1);
	}
	/**
	 * In Byteland they have a very strange monetary system.
	 *
	 * Each Bytelandian gold coin has an integer number written on it. A coin n can be exchanged in a bank into
	 * three coins: n/2, n/3 and n/4. But these numbers are all rounded down (the banks have to make a profit).
	 *
	 * You can also sell Bytelandian coins for American dollars. The exchange rate is 1:1. But you can not buy it.
	 *
	 * You have one gold coin. What is the maximum amount of American dollars you can get for it?
	 *
	 * Input
	 * The input will contain several test cases (not more than 10). Each testcase is a single line with a
	 * number n, 0 <= n <= 1 000 000 000. It is the number written on your coin.
	 *
	 * Output
	 * For each test case output a single line, containing the maximum amount of American dollars you can make.
	 *
	 * Example
	 * Input:
	 * 12
	 * 2
	 *
	 * Output:
	 * 13
	 * 2
	 * You can change 12 into 6, 4 and 3, and then change these into $6+$4+$3 = $13.
	 * If you try changing the coin 2 into 3 smaller coins, you will get 1, 0 and 0, and later you can get no more
	 * than $1 out of them. It is better just to change the 2 coin directly into $2.
	 */


	public static void main(String[] args) {
		int[] inputs = {12,2};

		for(int n: inputs){
			Coins coin = new Coins(n);
			System.out.print("Solving for n= "+ n + ", Max coins = ");
			System.out.println(coin.solveCoinsRecursive(n));
		}
	}

	public int solveCoinsRecursive(int n){
		//Base condition
		if (n==0 || n==1)	return 0;

		if (this.maxValues[n]!=-1){
			return this.maxValues[n];
		}

		int value =  solveCoinsRecursive(n/2) + solveCoinsRecursive(n/3) + solveCoinsRecursive(n/4);
		return maxValues[n]= Math.max(maxValues[n], Math.max(n, value));
	}
}


