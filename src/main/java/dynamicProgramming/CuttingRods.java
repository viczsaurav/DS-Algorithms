package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class CuttingRods {
    /**
     * Given a rod of length N and prices P[i] for i=1,2...n, where P[i] = price of rod of length i
     * Find the maximum total revenue you can make by cutting and selling the rod [assume no cost for cutting the rod]
     *
     * Example P[i] table:
     *
     * length(i)        1   2   3   4   5   6   7   8   9   10
     * price(P[i])      1   5   8   9   10  17  17  20  24  30
     *
     *
     * Solution approach:
     *
     *     divide the rod in 2 parts => 1, n-1 => Price => P1 + Revenue for (n-1) [R(n-1)]
     * or; divide the rod in 2 parts => 2, n-2 => Price => P2 + Revenue for (n-2) [R(n-2)]
     * or; divide the rod in 2 parts => 2, n=n-1=> Price => P(n-1) + Revenue for 1
     * or; No division => Price => P(n)
     *
     * Thus max Revenue, R[n] =  max{P1+R(n-1), P2+ R(n-2)........ P(n)+ R[0]} => Recursion
     *
     */

    private static final int[] prices = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
    private static Map<Integer, Integer> revenue = new HashMap<>();

    private static int getMaximumRevenue(int n){

        // Base conditions
        if (n==0) return 0;
        if (n==1) return prices[0];

        if (revenue.containsKey(n)){
            return revenue.get(n);
        }
        for(int i=1; i<=n;i++){
            int maxRevenue = -1 ;// Integer.MIN_VALUE
            for(int j=1;j<=i;j++){
                maxRevenue = Math.max(maxRevenue, prices[j-1] + revenue.getOrDefault(i-j, 0));
            }
            revenue.put(i, maxRevenue);
        }

        return revenue.get(n);
    }

    public static void main(String[] args) {
        System.out.println("Element: 2, Expected: 5, Actual: "+ getMaximumRevenue(2));
        System.out.println("Element: 3, Expected: 8, Actual: "+ getMaximumRevenue(3));
        System.out.println("Element: 4, Expected: 10, Actual: "+ getMaximumRevenue(4));
        System.out.println("Element: 5, Expected: 13, Actual: "+ getMaximumRevenue(5));
        System.out.println("Element: 6, Expected: 17, Actual: "+ getMaximumRevenue(6));
        System.out.println("Element: 7, Expected: 18, Actual: "+ getMaximumRevenue(7));
        System.out.println("Element: 8, Expected: 22, Actual: "+ getMaximumRevenue(8));
        System.out.println("Element: 9, Expected: 25, Actual: "+ getMaximumRevenue(9));
        System.out.println("Element: 10, Expected: 30, Actual: "+ getMaximumRevenue(10));
    }
}
