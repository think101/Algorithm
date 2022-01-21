package main.com.think101.leetcode.LongestCommonSubsequence;

public class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int row = text1.length();
        int col = text2.length();

        // dp[i][j]: text1.substring(i) and text2.substring(j) LCS's length
        // bottom up
        int[][] dp = new int[row+1][col+1];
        for(int i=0; i<row+1; i++)
            dp[i][col] = 0;
        for(int j=0; j<col+1; j++)
            dp[row][j] = 0;

        for(int i=row-1; i>=0; i--) {
            for(int j=col-1; j>=0; j--) {
                if(text1.charAt(i) == text2.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1]+1;
                }
                else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        return dp[0][0];
    }

    public int longestCommonSubsequence_TLE(String text1, String text2) {
        if(text1.length() == 0 || text2.length() == 0) return 0;
        if(text1.charAt(0) == text2.charAt(0))
            return longestCommonSubsequence_TLE(text1.substring(1), text2.substring(1)) + 1;
        else
            return Math.max(longestCommonSubsequence_TLE(text1, text2.substring(1)),
                    longestCommonSubsequence_TLE(text1.substring(1), text2));
    }
}
