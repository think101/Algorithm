package main.com.think101.leetcode.BestTimeBuyAndSellStock;

public class Solution2 {
    public int maxProfit(int[] prices) {
        int min = prices[0], res = 0;

        for(int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(s.maxProfit(new int[]{7,6,4,3,1}));
    }
}
