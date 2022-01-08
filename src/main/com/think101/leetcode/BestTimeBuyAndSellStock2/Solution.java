package main.com.think101.leetcode.BestTimeBuyAndSellStock2;

public class Solution {

    public int maxProfit(int[] prices) {
        int res = 0;
        int min = prices[0];

        int currentProfit = 0;
        for(int i=1; i<prices.length; i++) {
            if(prices[i] >= prices[i-1]) {
                currentProfit = prices[i]-min;
            }
            else {
                res += currentProfit;
                currentProfit = 0;
                min = prices[i];
            }
        }

        res += currentProfit;

        return res;
    }
}
