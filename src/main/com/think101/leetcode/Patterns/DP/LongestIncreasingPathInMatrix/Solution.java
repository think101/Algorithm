package main.com.think101.leetcode.Patterns.DP.LongestIncreasingPathInMatrix;

public class Solution {
    int res = 0;

    public int longestIncreasingPath(int[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                dp[i][j] = -1;
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                helper(i, j, matrix, dp);
                //printArray(dp);
            }
        }


        return res + 1;
    }

    private void printArray(int[][] dp){
        for (int[] ints : dp) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private int helper(int i, int j, int[][] matrix, int[][] dp){
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return 0;

        int t = 0;
        if(i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j] ) {
            if(dp[i - 1][j] == -1) dp[i - 1][j] = helper(i - 1, j, matrix, dp);
            t = Math.max(t, dp[i - 1][j] + 1);
        }
        if(j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            if(dp[i][j - 1] == -1) dp[i][j - 1] = helper(i, j - 1, matrix, dp);
            t = Math.max(t, dp[i][j - 1] + 1);
        }
        if(i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) {
            if(dp[i + 1][j] == -1) dp[i + 1][j] = helper(i + 1, j, matrix, dp);
            t = Math.max(t, dp[i + 1][j] + 1);
        }
        if(j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j]) {
            if(dp[i][j + 1] == -1) dp[i][j + 1] = helper(i, j + 1, matrix, dp);
            t = Math.max(t, dp[i][j + 1] + 1);
        }

        dp[i][j] = t;
        res = Math.max(t, res);

        return t;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestIncreasingPath(new int[][]{{7,6,1,1},{2,7,6,0},{1,3,5,1},{6,6,3,2}}));
    }
}
