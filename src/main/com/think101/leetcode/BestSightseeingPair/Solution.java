package main.com.think101.leetcode.BestSightseeingPair;

public class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int[] dp  = new int[values.length];

        int maxIndex = values[0];
        for(int i=1; i<values.length; i++) {
            dp[i] = maxIndex + values[i]-i;
            if(values[i]+i > maxIndex)
                maxIndex = values[i] + i;
        }

        int res = dp[0];
        for(int i=1; i<values.length; i++)
            if(dp[i] > res)
                res = dp[i];

        return res;
    }
}
