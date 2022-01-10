package main.com.think101.leetcode.BestTimeBuyAndSellStockWithFee;

public class Solution   {

    /*
     * s0 can buy
     * s1 can sell
     * s0[i] = max(s0[i-1], s1[i-1] + prices[i] - fee)
     * s1[i] = max(s1[i-1], s0[i-1] - prices[i])
     */
    public int maxProfit(int[] prices, int fee) {
        int[] s0 = new int[prices.length];
        int[] s1 = new int[prices.length];
        s0[0] = 0;
        s1[0] = -prices[0];     // the critical change

        for(int i=1; i<prices.length; i++) {
            s0[i] = Math.max(s0[i-1], s1[i-1] + prices[i] - fee);
            s1[i] = Math.max(s1[i-1], s0[i-1] - prices[i]);
        }

        return s0[prices.length-1];
    }


    /*
     * Count each transaction which has profit higher than fee
     * This is wrong
     */
    public int maxProfit_Wrong(int[] prices, int fee) {
        int res = 0;
        int min = prices[0];

        int currentProfit = 0;
        for(int i=1; i<prices.length; i++) {
            if(prices[i] >= prices[i-1]) {
                currentProfit = prices[i]-min;
            }
            else {
                res += Math.max(currentProfit - fee, 0);
                currentProfit = 0;
                min = prices[i];
            }
        }

        res += Math.max(currentProfit - fee, 0);

        return res;
    }

}
