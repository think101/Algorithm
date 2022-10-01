package main.com.think101.leetcode.Patterns.BFS.PacificAtlanticWaterFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SolutionWrong {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length, col = heights[0].length;
        int[][] s = new int[row][col];

        for(int j = 0; j < col; j++) {
            if(s[0][j] < 1)
                s[0][j] += 1;
            if(s[row-1][j] < 2)
                s[row-1][j] += 2;
        }


        for(int i = 0; i < row; i++){
            if(s[i][0] < 1)
                s[i][0] += 1;
            if(s[i][col-1] < 2)
                s[i][col-1] += 2;
        }

        for(int j = 0; j < col; j++) {
            dfs(0, j, 1, heights, s);
        }
        for(int i = 0; i < row; i++) {
            dfs(i, 0, 1, heights, s);
        }
        for(int j = 0; j < col; j++) {
            dfs(row-1, j, 2, heights, s);
        }
        for(int i = 0; i < row; i++) {
            dfs(i, col-1, 2, heights, s);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                if(s[i][j] >= 3)
                    res.add(Arrays.asList(i, j));

        return res;

    }

    private void dfs(int i, int j, int inc, int[][] heights, int[][] s) {
        int row = heights.length, col = heights[0].length;
        if(i < 0 || j < 0 || i >= row || j >= col) return;

        if(i-1 >= 0 && heights[i][j] >= heights[i-1][j] && s[i-1][j] != inc && s[i-1][j] < 3){
            s[i-1][j] += s[i][j];
            dfs(i-1, j, inc, heights, s);
        }
        if(i+1 < heights.length && heights[i][j] >= heights[i+1][j] && s[i+1][j] != inc && s[i+1][j] < 3){
            s[i+1][j] += s[i][j];
            dfs(i+1, j, inc, heights, s);
        }
        if(j-1 >= 0 && heights[i][j] >= heights[i][j-1] && s[i][j-1] != inc && s[i][j-1] < 3){
            s[i][j-1] += s[i][j-1];
            dfs(i, j-1, inc, heights, s);
        }
        if(j+1 < heights[0].length && heights[i][j] >= heights[i][j+1] && s[i][j+1] != inc && s[i][j+1] < 3){
            s[i][j+1] += s[i][j+1];
            dfs(i, j+1, inc, heights, s);
        }
    }

    public static void main(String[] args) {
        SolutionWrong s = new SolutionWrong();
        System.out.println(s.pacificAtlantic(new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}}));
    }
}
