package main.com.think101.leetcode.Patterns.BFS.PacificAtlanticWaterFlow;

import java.util.*;

public class Solution2 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length, col = heights[0].length;
        int[][] pac = new int[row][col];
        int[][] atl = new int[row][col];
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < row; i++) {
            pac[i][0] = 1;
            atl[i][col - 1] = 1;
        }

        for(int j = 0; j < col; j++) {
            pac[0][j] = 1;
            atl[row - 1][j] = 1;
        }

        bfs(heights, pac);
        bfs(heights, atl);

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(pac[i][j] == 2 && atl[i][j] == 2) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }

        return res;
    }

    private void bfs(int[][] heights, int[][] ocean) {
        int row = heights.length, col = heights[0].length;

        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(ocean[i][j] == 1) {
                    q.add(new int[]{i, j});
                    ocean[i][j] = 2;
                }
            }
        }

        while(q.size() > 0) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                int[] pos = q.poll();
                int r = pos[0], c = pos[1];

                if(r - 1 >= 0 && ocean[r - 1][c] == 0 && heights[r - 1][c] >= heights[r][c]) {q.add(new int[]{r - 1, c}); ocean[r - 1][c] = 2;}
                if(r + 1 < row && ocean[r + 1][c] == 0 && heights[r + 1][c] >= heights[r][c]){q.add(new int[]{r + 1, c}); ocean[r + 1][c] = 2;}
                if(c - 1 >= 0 && ocean[r][c - 1] == 0 && heights[r][c - 1] >= heights[r][c]) {q.add(new int[]{r, c - 1}); ocean[r][c - 1] = 2;}
                if(c + 1 < col && ocean[r][c + 1] == 0 && heights[r][c + 1] >= heights[r][c]){q.add(new int[]{r, c + 1}); ocean[r][c + 1] = 2;}
            }
        }
    }

    public static void main(String[] args) {
        int[][] heights = new int[][]{
            {1,2,2,3,5},
            {3,2,3,4,4},
            {2,4,5,3,1},
            {6,7,1,4,5},
            {5,1,1,2,4}
        };
        Solution2 s = new Solution2();
        List<List<Integer>> res = s.pacificAtlantic(heights);
        System.out.println(res);
    }
}
