package main.com.think101.leetcode.BestTimeBuyAndSellStock;

public class Solution {
    public int maxProfit(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;

        int min = prices[0];
        int res = 0;
        for(int i=1; i<prices.length; i++) {
            dp[i] = prices[i] > min ? prices[i] - min : 0;
            if(dp[i] > res)
                res = dp[i];

            if(prices[i] < min)
                min = prices[i];
        }

        return res;
    }
}
