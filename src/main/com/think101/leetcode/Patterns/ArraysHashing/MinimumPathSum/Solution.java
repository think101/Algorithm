package main.com.think101.leetcode.Patterns.ArraysHashing.MinimumPathSum;

public class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length, col = grid[0].length;

        for(int i = 1; i < row; i++) grid[i][0] = grid[i - 1][0] + grid[i][0];
        for(int j = 1; j < col; j++) grid[0][j] = grid[0][j - 1] + grid[0][j];

        for(int i = 1; i < row; i++) {
            for(int j = 1; j < col; j++) {
                grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
            }
        }

        return grid[row - 1][col - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{1, 2}, {1, 1}};
        System.out.println(s.minPathSum(grid));
    }
}
