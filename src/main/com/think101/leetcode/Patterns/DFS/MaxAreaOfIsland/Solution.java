package main.com.think101.leetcode.Patterns.DFS.MaxAreaOfIsland;

public class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    int t = dfs(i, j, 0, grid);
                    res = Math.max(res, t);
                }
            }
        }

        return res;
    }

    private int dfs(int i, int j, int cnt, int[][] grid) {
        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            cnt++;
            grid[i][j] = 0;

            cnt = dfs(i-1, j, cnt, grid);
            cnt = dfs(i+1, j, cnt, grid);
            cnt = dfs(i, j-1, cnt, grid);
            cnt = dfs(i, j+1, cnt, grid);
        }

        return cnt;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxAreaOfIsland(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}}));
    }
}
