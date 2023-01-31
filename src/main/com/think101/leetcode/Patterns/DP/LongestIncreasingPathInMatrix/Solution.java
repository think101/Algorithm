package main.com.think101.leetcode.Patterns.DP.LongestIncreasingPathInMatrix;

public class Solution {
    int res = 0;

    public int longestIncreasingPath(int[][] matrix) {
        helper(0, 0, matrix, new int[matrix.length][matrix[0].length]);
        return res;
    }

    private int helper(int i, int j, int[][] matrix, int[][] dp){
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return 0;

        int t = 0;
        if(i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) t = Math.max(t, dp[i - 1][j] + 1);
        if(j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) t = Math.max(t, dp[i][j - 1] + 1);
        if(i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j]) t = Math.max(t, helper(i + 1, j, matrix, dp) + 1);
        if(j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j]) t = Math.max(t, helper(i, j + 1, matrix, dp) + 1);

        res = Math.max(t, res);

        return t;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestIncreasingPath(new int[][]{{9,9,4},{6,6,8},{2,1,1}}));
    }
}
