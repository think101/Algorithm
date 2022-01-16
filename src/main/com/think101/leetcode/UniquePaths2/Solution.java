package main.com.think101.leetcode.UniquePaths2;

public class Solution {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] != 1 ? 1 : 0;

        for(int i=1; i<m; i++){
            dp[i][0] = obstacleGrid[i][0] != 1 ? Math.min(1, dp[i-1][0]) : 0;
        }
        for(int i=1; i<n; i++) {
            dp[0][i] = obstacleGrid[0][i] != 1 ? Math.min(1, dp[0][i-1]) : 0;
        }

        for(int i=1; i<m; i++) {
            for(int j=1; j<n; j++) {
                if(obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }

        return dp[m-1][n-1];

    }
}

// hint 1: pay attention to the edge cases:
// on the 1st row or 1st column, if there is obstacle anywhere then the spaces after that should be blocked (value 0 in dp)