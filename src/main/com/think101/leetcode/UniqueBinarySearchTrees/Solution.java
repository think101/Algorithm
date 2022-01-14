package main.com.think101.leetcode.UniqueBinarySearchTrees;

public class Solution {
    public int numTrees(int n) {
        if(n<=2) return n;

        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++) {
            dp[i] += dp[i-1]*2;

            for(int j=1; j<i-1; j++) {
                dp[i] += dp[j]*dp[i-1-j];
            }
        }

        return dp[n];
    }
}
