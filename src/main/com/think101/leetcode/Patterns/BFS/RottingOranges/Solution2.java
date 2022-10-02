package main.com.think101.leetcode.Patterns.BFS.RottingOranges;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public int orangesRotting(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        Queue<int[]> rotten = new LinkedList<>();

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 2)
                    rotten.add(new int[]{i, j});
            }
        }

        int res = 0;
        while(rotten.size() > 0) {
            res++;
            int len = rotten.size();

            for(int k = 0; k < len; k++) {
                int[] r = rotten.poll();
                int i = r[0], j = r[1];

                if(i-1 >= 0 && grid[i-1][j] == 1) {
                    grid[i-1][j] = 2;
                    rotten.add(new int[]{i-1, j});
                }
                if(i+1 < row && grid[i+1][j] == 1) {
                    grid[i+1][j] = 2;
                    rotten.add(new int[]{i+1, j});
                }
                if(j-1 >= 0 && grid[i][j-1] == 1) {
                    grid[i][j-1] = 2;
                    rotten.add(new int[]{i, j-1});
                }
                if(j+1 < col && grid[i][j+1] == 1) {
                    grid[i][j+1] = 2;
                    rotten.add(new int[]{i, j+1});
                }
            }
        }

        for (int[] ints : grid)
            for (int j = 0; j < col; j++)
                if (ints[j] == 1)
                    return -1;

        return res > 0 ? res-1 : 0;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        Solution2 s = new Solution2();
        System.out.println(s.orangesRotting(grid));
    }
}
