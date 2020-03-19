package interviewCake;

public class StockPrice {

	/**
	 * Writing programming interview questions hasn't made me rich yet ... so I might give up and start trading Apple stocks all day instead.
	 *
	 * First, I wanna know how much money I could have made yesterday if I'd been trading Apple stocks all day.
	 *
	 * So I grabbed Apple's stock prices from yesterday and put them in an array called stockPrices, where:
	 *
	 * The indices are the time (in minutes) past trade opening time, which was 9:30am local time.
	 * The values are the price (in US dollars) of one share of Apple stock at that time.
	 * So if the stock cost $500 at 10:30am, that means stockPrices[60] = 500.
	 *
	 * Write an efficient method that takes stockPrices and returns the best profit I could have made from one purchase and one sale of one share of Apple stock yesterday.
	 *
	 * For example:
	 *
	 *   int[] stockPrices = new int[] {10, 7, 5, 8, 11, 9};
	 *
	 * getMaxProfit(stockPrices);
	 * // returns 6 (buying for $5 and selling for $11)
	 *
	 * No "shorting"—you need to buy before you can sell. Also, you can't buy and sell in the same time step—at least 1 minute has to pass.
	 *
	 */

	public static int getMaxProfit(int[] stockPrices) {

		int min = stockPrices[0];
		int maxProfit = stockPrices[1] - min;


		for(int i=1;i<stockPrices.length;i++){
			// see what our profit would be if we bought at the min price and sold at the current price
			int potentialProfit = stockPrices[i] - min;

			maxProfit = Math.max(maxProfit,potentialProfit);
			min = Math.min(min, stockPrices[i]);
		}

		return maxProfit;

	}
	public static int getMaxProfitWithIfAndBug(int[] stockPrices) {

		// handled in test cases
//		if (stockPrices.length < 2){
//			throw new Exception("Atleast 2 prices required");
//		}

		// calculate the max profit
		int min = stockPrices[0];
		int max = stockPrices[1];
		int maxProfit = max-min;

		for (int i=1;i<stockPrices.length-1;i++){
			if (min > stockPrices[i]){
				min = stockPrices[i];
				max = stockPrices[i+1];
			} else {
				// We can also just keep track of min/max for whole array, but always decreasing case is not handled then.
				max = stockPrices[i+1];
			}
			maxProfit = Math.max(maxProfit, (max-min));
		}

		return maxProfit;
	}

}
