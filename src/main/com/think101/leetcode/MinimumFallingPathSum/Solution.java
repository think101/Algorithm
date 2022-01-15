package main.com.think101.leetcode.MinimumFallingPathSum;

public class Solution {

    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int[][] dp = new int[row][col];
        System.arraycopy(matrix[row - 1], 0, dp[row - 1], 0, col);

        //for each line
        for(int r = row-2; r >= 0; r-- ){
            for(int c=0; c<col; c++) {
                if(c-1>=0) {
                    if(c+1<col) {
                        dp[r][c] = matrix[r][c] +  Math.min(dp[r+1][c-1], Math.min(dp[r+1][c], dp[r+1][c+1]));
                    }
                    else {
                        dp[r][c] = matrix[r][c] + Math.min(dp[r+1][c-1], dp[r+1][c]);
                    }
                }
                else {
                    if(c+1<col) {
                        dp[r][c] = matrix[r][c] + Math.min(dp[r+1][c], dp[r+1][c+1]);
                    }
                    else {
                        dp[r][c] = matrix[r][c];
                    }
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i=0; i<col; i++) {
            if(dp[0][i] < res)
                res = dp[0][i];
        }

        return res;
    }

}
