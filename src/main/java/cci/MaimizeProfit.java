package cci;
/*

Given an array of stock prices for a day, sorted in time order,  like

int stock_prices_yesterday[] = {10, 7, 5, 8, 11, 9}; // -> 6


write a program to calculate maximum possible profit trading this stock on that day.
// You can only sell what you bought previously (no short selling)
// You can only buy and sell once

// In above example, expected output is 6 (since we can buy at 5 and sell at 11 in the above case)
*/

public class MaimizeProfit {

	public static void main(String[] args) {
		int stock_prices_yesterday[] = { 10, 7, 5, 8, 11, 9 };
		int stock_prices_yesterday1[] = { 5, 7, 6, 4, 3, 2 };
		oneBuy1sellN2(stock_prices_yesterday);
		oneBuy1sellN2(stock_prices_yesterday1);
		oneBuy1sellN(stock_prices_yesterday);
		oneBuy1sellN(stock_prices_yesterday1);

	}
	
	public static void oneBuy1sellN2(int[] stock_prices_yesterday) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < stock_prices_yesterday.length; i++) {
			for (int j = i + 1; j < stock_prices_yesterday.length; j++) {
				int diff = stock_prices_yesterday[j] - stock_prices_yesterday[i];
				if (diff > 0 && max < diff)
					max = diff;
			}
		}
		System.out.println(max);
	}
	
	public static void oneBuy1sellN(int[] stock) {
		int maxDiff = Integer.MIN_VALUE;
		int max = stock[0];
		int min = stock[0];

		for (int i = 1; i < stock.length; i++) {
			if (stock[i]> max) {
				max= stock[i];
				int diff = max-min;
				if (maxDiff < diff)	
					maxDiff = diff;
				
			}
			else {
				min = stock[i];
				max = stock[i];
			}
		}
		System.out.println(maxDiff);
	}

}
