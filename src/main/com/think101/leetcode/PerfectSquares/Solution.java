package main.com.think101.leetcode.PerfectSquares;

public class Solution {

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;

        for(int i=2; i<=n; i++) {
            dp[i] = i;
            if(isPerfectSquare(i)) {
                dp[i] = 1;
                continue;
            }

            for(int j=1; j<=(i+1)/2; j++) {
                int t = dp[j] + dp[i-j];
                if(t < dp[i])
                    dp[i] = t;
            }
        }

        return dp[n];
    }

    private boolean isPerfectSquare(int n) {
        int t = (int)Math.sqrt(n);
        return n == t * t;
    }
}
