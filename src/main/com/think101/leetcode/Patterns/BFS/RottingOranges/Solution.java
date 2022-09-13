package main.com.think101.leetcode.Patterns.BFS.RottingOranges;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> rottens = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 2) {
                    rottens.add(new int[]{i, j});
                }
            }
        }

        while(rottens.size() > 0) {
            res++;
            int len = rottens.size();

            for(int k = 0; k < len; k++){
                int[] elem = rottens.poll();
                int i = elem[0];
                int j = elem[1];

                if(i-1 >= 0 && grid[i-1][j] == 1) {
                    grid[i-1][j] = 2;
                    rottens.add(new int[]{i-1, j});
                }
                if(i+1 < row && grid[i+1][j] == 1) {
                    grid[i+1][j] = 2;
                    rottens.add(new int[]{i+1, j});
                }
                if(j-1 >= 0 && grid[i][j-1] == 1) {
                    grid[i][j-1] = 2;
                    rottens.add(new int[]{i, j-1});
                }
                if(j+1 < col && grid[i][j+1] == 1) {
                    grid[i][j+1] = 2;
                    rottens.add(new int[]{i, j+1});
                }
            }
        }

        for (int[] ints : grid) {
            for (int j = 0; j < col; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }

        return res > 0 ? res-1 : 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = new int[][]{{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(solution.orangesRotting(grid));
    }
}
