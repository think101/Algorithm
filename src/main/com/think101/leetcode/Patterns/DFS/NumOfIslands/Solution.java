package main.com.think101.leetcode.Patterns.DFS.NumOfIslands;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int numIslands(char[][] grid) {
        List<int[]> ones = new ArrayList<>();
        int res = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    ones.add(new int[]{i, j});
                }
            }
        }

        for(int[] one : ones) {
            if(grid[one[0]][one[1]] == '1'){
                res++;
                dfs(one[0], one[1], grid);
            }
        }

        return res;
    }

    private void dfs(int i, int j, char[][] grid) {
        grid[i][j] = '0';

        if(i-1 >= 0 && grid[i-1][j] == '1') dfs(i-1, j, grid);
        if(i+1 < grid.length && grid[i+1][j] == '1') dfs(i+1, j, grid);
        if(j-1 >= 0 && grid[i][j-1] == '1') dfs(i, j-1, grid);
        if(j+1 < grid[0].length && grid[i][j+1] == '1') dfs(i, j+1, grid);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numIslands(
                new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
        System.out.println(s.numIslands(
                new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}));
    }
}
