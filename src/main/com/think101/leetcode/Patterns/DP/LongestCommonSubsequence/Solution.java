package main.com.think101.leetcode.Patterns.DP.LongestCommonSubsequence;

public class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m][n];

        for(int j = 0; j < n; j++) {
            if((j - 1 >= 0 && dp[0][j - 1] == 1) || text1.charAt(j) == text2.charAt(0)) dp[0][j] = 1;
        }

        for(int i = 0; i < m; i++) {
            if((i - 1 >= 0 && dp[i - 1][0] == 1) || text1.charAt(0) == text2.charAt(i)) dp[i][0] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                int t = text1.charAt(j) == text2.charAt(i) ? dp[i-1][j-1] : 0;

                dp[i][j] = Math.max(t, Math.max(dp[i-1][j], dp[i][j-1]));
            }
        }

        return dp[m-1][n-1];
    }
}
