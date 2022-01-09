package main.com.think101.leetcode.BestTimeBuyAndSellStockWithCooldown;

public class Solution {

    public static void main(String[] args) {
        int[] prices = new int[]{6,1,3,2,4,7};

        System.out.println(maxProfit(prices));
    }

    /*
     * s0: can buy, can't sell
     * s1: hold a stock, can't buy, can sell
     * s2: sold, can't buy, can't sell
     */
    public static int maxProfit(int[] prices) {
        int[] s0 = new int[prices.length];
        int[] s1 = new int[prices.length];
        int[] s2 = new int[prices.length];

        s0[0] = 0;
        s1[0] = -prices[0];
        s2[0] = Integer.MIN_VALUE;

        for(int i=1; i<prices.length; i++) {
            s0[i] = Math.max(s0[i-1], s2[i-1]);
            s1[i] = Math.max(s0[i-1] - prices[i], s1[i-1]);
            s2[i] = s1[i-1] + prices[i];
        }

        return Math.max(s0[prices.length-1], s2[prices.length-1]);
    }

    /*
     * Wrong solution...
     * The idea is think about the pattern prices[i-1] prices[i] prices[i+1] prices[i+2] for example 1 5 2 8
     * and decides whether should sell at prices[i-1] or prices[i]
     * An example failed case is: 6 1 3 2 4 7
     */
    public static int maxProfit_Wrong(int[] prices) {
        int[] dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];

        int res = 0;
        int currentProfit = 0;
        for(int i=1; i<prices.length; i++) {
            if(prices[i] >= prices[i-1]) {
                if(i+1<prices.length && i+2 < prices.length
                        && prices[i+1] < prices[i] && prices[i+2] > prices[i+1]) {
                    if(Math.abs(prices[i-1] - prices[i+1]) > Math.abs(prices[i] - prices[i+2])) {
                        res += prices[i-1] - min;
                        min = prices[i+1];
                        i++;
                    }
                    else {
                        res += prices[i] - min;
                        min = prices[i+2];
                        i = i+2;
                    }
                }
                else {
                    currentProfit = prices[i] - min;
                }
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
