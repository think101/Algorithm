package main.com.think101.leetcode.Patterns.BFS.MaxAreaOfIsland;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int res = 0;

    public int maxAreaOfIsland(int[][] grid) {
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    bfs(grid, i, j);
                }
            }
        }

        return res;
    }

    private void bfs(int[][] grid, int i, int j) {
        int area = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        grid[i][j] = 0;

        while(queue.size() > 0) {
            int[] pos = queue.poll();
            i = pos[0];
            j = pos[1];

            area++;
            if(i - 1 >= 0 && grid[i - 1][j] == 1) {queue.add(new int[]{i - 1, j}); grid[i - 1][j] = 0;}
            if(i + 1 < grid.length && grid[i + 1][j] == 1) {queue.add(new int[]{i + 1, j}); grid[i + 1][j] = 0;}
            if(j - 1 >= 0 && grid[i][j - 1] == 1) {queue.add(new int[]{i, j - 1}); grid[i][j - 1] = 0;}
            if(j + 1 < grid[0].length && grid[i][j + 1] == 1) {queue.add(new int[]{i, j + 1}); grid[i][j + 1] = 0;}
        }

        res = Math.max(area, res);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxAreaOfIsland(new int[][]{
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0}}));
    }
}