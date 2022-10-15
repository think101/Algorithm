package main.com.think101.leetcode.Patterns.SlidingWindow.BestTimeBuyAndSellStock;

public class Solution {
    public int maxProfit(int[] prices) {
        int prevMin = prices[0];
        int res = 0;

        for(int i = 1; i < prices.length; i++) {
            prevMin = Math.min(prevMin, prices[i]);
            res = Math.max(res, prices[i] - prevMin);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
