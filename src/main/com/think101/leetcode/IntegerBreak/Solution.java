package main.com.think101.leetcode.IntegerBreak;

public class Solution {

    public static void main(String[] args) {
        System.out.println(integerBreak(8));
    }

    public static int integerBreak(int n) {

        int[] dp = new int[n+1];
        dp[1] = 1; dp[2] = 1;

        for(int i=3; i<=n; i++) {
            for(int j=1; j<=(i+1)/2; j++) {
                int t = max(dp[j]*dp[i-j], dp[j]*(i-j), j*dp[i-j], j*(i-j));
                if(t > dp[i])
                    dp[i] = t;
            }
        }

        return dp[n];
    }

    private static int max(int a, int b, int c, int d) {
        return Math.max(a, Math.max(b, Math.max(c, d)));
    }
}
