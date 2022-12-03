package main.com.think101.leetcode.Patterns.DP.CoinChange;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        dp[0] = 1;

        for(int i = 1; i <= amount; i++) {
            int t = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (amount - coin < 0) break;

                t = Math.min(dp[amount - coin] + 1, t);
            }

            dp[i] = t;
        }

        return dp[amount];
    }
}