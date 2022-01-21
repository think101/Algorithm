package main.com.think101.leetcode.EditDistance;

public class Solution {

    public int minDistance(String word1, String word2) {
        int row = word1.length();
        int col = word2.length();

        // dp[i][j]: edit distance between word1.substring(i) and word2.substring(j)
        int[][] dp = new int[row+1][col+1];

        for(int i=0; i<row+1; i++)
            dp[i][col] = row-i;
        for(int j=0; j<col+1; j++)
            dp[row][j] = col-j;

        for(int i=row-1; i>=0; i--) {
            for(int j=col-1; j>=0; j--) {
                if(word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i+1][j+1];
                }
                else {
                    dp[i][j] = Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1])) + 1;
                }
            }
        }

        return dp[0][0];
    }
}
