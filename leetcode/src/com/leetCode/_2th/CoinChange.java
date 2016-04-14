package com.leetCode._2th;
/**
 * You are given coins of different denominations and a total amount of money amount. 
 * 
 * Write a function to compute the fewest number of coins that you need to make up that amount. 
 * 
 * If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.


 * 
 * @author Zealot
 * @date 2016年4月13日 下午5:26:51 
 *
 */
public class CoinChange {
	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		dp[0] = 0;
		for(int i = 1; i < dp.length; i++) {
			dp[i] = amount+1;
		}
		for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < coins.length; ++j) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
		return dp[amount] > amount ? -1 : dp[amount];
	}
}
