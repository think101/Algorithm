package main.com.think101.leetcode.Patterns.DP.BestTimeBuyAndSellStockWithCooldown;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<List<Integer>, Integer> dp = new HashMap<>();

    public int maxProfit(int[] prices) {
        return dfs(0, prices, true);
    }

    private int dfs(int i, int[] prices, boolean buying) {
        if(i >= prices.length) return 0;
        List<Integer> l = Arrays.asList(i, buying ? 1 : 0);
        if(dp.containsKey(l)) return dp.get(l);

        int cooldown = dfs(i+1, prices, buying);
        if(buying) {
            int buy = dfs(i + 1, prices, false) - prices[i];
            dp.put(l, Math.max(buy, cooldown));
        }
        else {
            int sell = dfs(i + 2, prices, true) + prices[i];
            dp.put(l, Math.max(sell, cooldown));
        }

        return dp.get(l);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProfit(new int[]{1,2,3,0,2}));
    }

}