package main.com.think101.leetcode.MinCostClimbStairs;

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        if(cost.length==1) return cost[0];
        if(cost.length==2) return Math.min(cost[0], cost[1]);

        int[] minCost = new int[cost.length];
        minCost[0] = cost[0];
        minCost[1] = cost[1];
        for(int i=2; i<cost.length; i++)
            minCost[i] = Math.min(minCost[i-1], minCost[i-2]) + cost[i];

        return Math.min(minCost[cost.length-1], minCost[cost.length-2]);
    }
}
