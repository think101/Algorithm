package main.com.think101.leetcode.Patterns.DP.CoinChange;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount+1];
        dp[0] = 0;

        for(int i = 1; i <= amount; i++) {
            int t = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin < 0) break;

                if (dp[i - coin] != -1) {
                    t = Math.min(dp[i - coin] + 1, t);
                }
            }

            dp[i] = t == Integer.MAX_VALUE ? -1 : t;
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.coinChange(new int[]{2}, 3));
        System.out.println(s.coinChange(new int[]{1, 2, 5}, 11));
    }
}