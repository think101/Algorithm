package main.com.think101.leetcode.Patterns.BFS.PacificAtlanticWaterFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length, col = heights[0].length;
        int[][] status_p = new int[row][col];
        int[][] status_a = new int[row][col];

        for(int j = 0; j < col; j++) {
            dfs(0, j, 0, heights, status_p);
            dfs(row-1, j, 0, heights, status_a);
        }

        for(int i = 0; i < row; i++){
            dfs(i, 0, 0, heights, status_p);
            dfs(i, col-1, 0, heights, status_a);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                if(status_p[i][j] == 1 && status_a[i][j] == 1)
                    res.add(Arrays.asList(i, j));

        return res;
    }

    private void dfs(int i, int j, int height, int[][] heights, int[][] s) {
        int row = heights.length, col = heights[0].length;
        if(i < 0 || j < 0 || i >= row || j >= col) return;
        if(s[i][j] > 0 || heights[i][j] < height) return;

        s[i][j] = 1;
        dfs(i-1, j, heights[i][j], heights, s);
        dfs(i+1, j, heights[i][j], heights, s);
        dfs(i, j-1, heights[i][j], heights, s);
        dfs(i, j+1, heights[i][j], heights, s);
    }

    public static void main(String[] args) {
        int[][] heights = new int[][]{
            {1,2,2,3,5},
            {3,2,3,4,4},
            {2,4,5,3,1},
            {6,7,1,4,5},
            {5,1,1,2,4}
        };
        Solution s = new Solution();
        List<List<Integer>> res = s.pacificAtlantic(heights);
        System.out.println(res);
    }
}
