package main.com.think101.leetcode.MaximalSquare;

public class Solution {

    public static void main(String[] args) {
        //char[][] matrix={ {'1','0','1','0','0'}, {'1','0','1','1','1'}, {'1','1','1','1','1'}, {'1','0','0','1','0'} };
        //char[][] matrix={ {'0','0','0','1'}, {'1','1','0','1'}, {'1','1','1','1'}, {'0','1','1','1'}, {'0','1','1','1'} };
        char[][] matrix={ {'0','1','1','0','0','1','0','1','0','1'}, {'0','0','1','0','1','0','1','0','1','0'},
                {'1','0','0','0','0','1','0','1','1','0'}, {'0','1','1','1','1','1','1','0','1','0'},
                {'0','0','1','1','1','1','1','1','1','0'}, {'1','1','0','1','0','1','1','1','1','0'},
                {'0','0','0','1','1','0','0','0','1','0'}, {'1','1','0','1','1','0','0','1','1','1'},
                {'0','1','0','1','1','0','1','0','1','1'}};

        System.out.println(maximalSquare(matrix));
    }

    /*
     * dp[i][j]: area of max square whose low right corner is matrix[i][j]
     * when calculate dp[i][j], check dp[i-1][j-1], if is 1,4,9, etc. then check the lower edge and right edge of the square
     * whose low right corner is matrix[i][j]
     */
    public static int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int max = 0;

        int[][] dp = new int[row][col];
        for(int i=0; i<row; i++) {
            dp[i][0] = matrix[i][0]-'0';
            if(dp[i][0] > max)
                max = dp[i][0];
        }

        for(int i=0; i<col; i++) {
            dp[0][i] = matrix[0][i]-'0';
            if(dp[0][i] > max)
                max = dp[0][i];
        }

        for(int i=1; i<row; i++) {
            for(int j=1; j<col; j++) {
                if(matrix[i][j] == '1') {
                    if(dp[i-1][j-1] > 0) {
                        int t = (int) Math.sqrt(dp[i-1][j-1]);

                        int valid = 0;

                        // order is important
                        for(int k=1; k<=t; k++) {
                            if(matrix[i-k][j] == '0' || matrix[i][j-k] == '0') {
                                break;
                            }
                            valid = k;
                        }

                        if(valid > 0) {
                            dp[i][j] = (valid+1) * (valid+1);
                        }
                        else {
                            dp[i][j] = 1;
                        }
                    }
                    else {
                        dp[i][j] = 1;
                    }
                }
                else {
                    dp[i][j] = 0;
                }

                if(dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }

        return max;
    }
}
