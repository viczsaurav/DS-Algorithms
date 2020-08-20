package leetcode;

public class SellStocksMultipleTimes_DP_P122 {

    /**
     * Say you have an array prices for which the ith element is the price of a given stock on day i.
     *
     * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
     * (i.e., buy one and sell one share of the stock multiple times).
     *
     * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock
     * before you buy again).
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices.length==0 || prices.length==1)
            return 0;

        int maxProfit =0;

        for(int i=1; i< prices.length;i++){
            if (prices[i]> prices[i-1]) {
                maxProfit += prices[i] - prices[i-1];
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] input1 =  new int[]{7,1,5,3,6,4};
        int[] input2 =  new int[]{1,2,3,4,5};
        int[] input3 =  new int[]{7,6,4,3,1};

        System.out.println("Expected: 7, Actual: "+ maxProfit(input1));
        System.out.println("Expected: 4, Actual: "+ maxProfit(input2));
        System.out.println("Expected: 0, Actual: "+ maxProfit(input3));
    }
}
