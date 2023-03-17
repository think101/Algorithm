package main.com.think101.leetcode.Patterns.BFS.RottingOranges;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int row = grid.length, col = grid[0].length;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int res = 0;
        while(q.size() > 0) {
            int size = q.size();
            res++;

            for(int a = 0; a < size; a++) {
                int[] pos = q.poll();
                int i = pos[0], j = pos[1];

                if(i - 1 >= 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    q.add(new int[]{i - 1, j});
                }
                if(i + 1 < row && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    q.add(new int[]{i + 1, j});
                }
                if(j - 1 >= 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    q.add(new int[]{i, j - 1});
                }
                if(j + 1 < col && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    q.add(new int[]{i, j + 1});
                }
            }
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return res > 0 ? res - 1 : 0;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        int[][] grid = new int[][]{
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(s.orangesRotting(grid));
    }
}
