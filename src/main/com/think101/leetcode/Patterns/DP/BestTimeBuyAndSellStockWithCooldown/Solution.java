package main.com.think101.leetcode.Patterns.DP.BestTimeBuyAndSellStockWithCooldown;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<int[], Integer> dp = new HashMap<>();

    public int maxProfit(int[] prices) {
        return dfs(0, prices, true);
    }

    private int dfs(int i, int[] prices, boolean buying) {
        if(i >= prices.length) return 0;
        if(dp.containsKey(new int[]{i, buying ?  1 : 0})) return dp.get(new int[]{i, buying ?  1 : 0});

        int cooldown = dfs(i+1, prices, buying);
        if(buying) {
            int buy = dfs(i + 1, prices, false) - prices[i];
            dp.put(new int[]{i, 0}, Math.max(buy, cooldown));
        }
        else {
            int sell = dfs(i + 2, prices, true) + prices[i];
            dp.put(new int[]{i, 1}, Math.max(sell, cooldown));
        }

        return dp.get(new int[]{i, buying ? 1 : 0});
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{1,2,3,0,2}));
    }

}