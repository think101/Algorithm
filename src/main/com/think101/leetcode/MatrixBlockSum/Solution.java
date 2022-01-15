package main.com.think101.leetcode.MatrixBlockSum;

public class Solution {

    public int[][] matrixBlockSum(int[][] mat, int k) {
        int row = mat.length, col = mat[0].length;

        // dp[i][j] indicate sum of mat[0][0] -> mat[i][j]
        int[][] dp = new int[row][col];
        dp[0][0] = mat[0][0];
        for(int i=1; i<row; i++) {
            dp[i][0] = mat[i][0] + dp[i-1][0];
        }
        for(int i=1; i<col; i++) {
            dp[0][i] = mat[0][i] + dp[0][i-1];
        }

        for(int i=1; i<row; i++) {
            for(int j=1; j<col; j++) {
                dp[i][j] = mat[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }

        int[][] res = new int[row][col];
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                int rowStart = Math.max(i - k, 0);
                int rowEnd = i+k >= row ? row-1 : i+k;

                int colStart = Math.max(j - k, 0);
                int colEnd = j+k >= col ? col-1 : j+k;

                res[i][j] = dp[rowEnd][colEnd];
                if(colStart-1 >=0 && rowStart-1 >= 0 ) {
                    // this is the key line!
                    res[i][j] = res[i][j] - dp[rowStart-1][colEnd] - dp[rowEnd][colStart-1] + dp[rowStart-1][colStart-1];
                }
                else if(rowStart-1 >=0 ) {
                    res[i][j] -= dp[rowStart-1][colEnd];
                }
                else if(colStart-1 >= 0) {
                    res[i][j] -= dp[rowEnd][colStart-1];
                }
            }
        }

        return res;
    }
}
