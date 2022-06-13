package main.com.think101.leetcode.contest.Test297.MinPathCostInGrid;

class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] cost = new int[row][col];

        //  bottom up
        for(int i = row-1; i >= 0; i--){
            for(int j = 0; j < col; j++) {
                if(i == row-1) {
                    cost[i][j] = grid[i][j];
                    continue;
                }

                int[] mv = moveCost[grid[i][j]];
                int t = Integer.MAX_VALUE;
                for(int k = 0; k < mv.length; k++) {
                    t = Math.min(t, grid[i][j] + cost[i+1][k] + mv[k]);
                }

                cost[i][j] = t;
            }
        }

        int res = Integer.MAX_VALUE;
        for(int j = 0; j < col; j++) {
            res = Math.min(res, cost[0][j]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{{5, 3}, {4, 0}, {2, 1}};
        int[][] moveCost = new int[][]{{9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}};
        Solution s = new Solution();
        System.out.println(s.minPathCost(grid, moveCost));
    }
}
