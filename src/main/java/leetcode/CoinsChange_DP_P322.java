package leetcode;
import java.util.*;

public class CoinsChange_DP_P322 {
    public static  int coinChange(int[] coins, int amount) {

        // Base conditions
        if (amount==0)  return 0;
        if (coins.length==0)    return -1;
        /**

         F(S) = minimum number of coins needed to make change for amount S using coin denominations [c0,....c(n-1)]
         where S= amount, C= current coin
         F(S) = F(S-C) +1
         So here, C is the current coin and F(S-C) is the min number of coins for needed for amount=(S-C)
         [not counting current coin denomination], thus F(S) is equal to the last coin needed +1 coz numbers of
         ways of selecting current coin is 1.

         In the bottom up approach, always break the problem and start if the amount is 1 (i.e solution for 1 item),
         then optimum solution for 2nd item will be optimal solution for 1st item + current ,i.e

         F(0) = 0 [amount=0]
         F(1) = F(0)+ 1
         F(2) = F(1) + 1 ...

         **/

        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1);
        dp[0]=0;       // The min number of coins for amount=0 is 0

        for (int i=1; i<=amount; i++){
            for (int j=0; j<coins.length;j++){
                if(coins[j]<=i){
                    dp[i] = Math.min(dp[i], 1 + dp[i-coins[j]]);
                }
            }
        }

        return (dp[amount]>amount? -1:dp[amount]);

    }

    /*
    Fails for:
                [186,419,83,408]
                6249
    */

//     public int coinChange(int[] coins, int amount) {
//         if (amount==0) return 0;
//         if (coins.length==0)
//             return -1;

//         Arrays.sort(coins);
//         int cnt=0;

//         for (int i=coins.length-1; i>=0; i--){
//             cnt += amount/coins[i];
//             amount = amount%coins[i];

//             if (amount==0)  break;
//         }
//         if (amount!=0) return -1;
//         else return cnt;
//     }


    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        int amount = 6249;

        System.out.println("Expected = 20, Actual: "+ coinChange(coins, amount));
    }
}
