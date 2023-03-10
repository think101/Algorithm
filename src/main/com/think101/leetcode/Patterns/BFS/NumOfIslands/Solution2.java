package main.com.think101.leetcode.Patterns.BFS.NumOfIslands;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public int numIslands(char[][] grid) {
        int res = 0;

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    res++;
                    bfs(grid, i, j);
                }
            }
        }

        return res;
    }

    private void bfs(char[][] grid, int i, int j) {

        Queue<int[]> q = new LinkedList<>();
        grid[i][j] = 0;
        q.add(new int[]{i, j});

        while(q.size() > 0) {
            int[] pos = q.poll();
            i = pos[0];
            j = pos[1];

            if(i - 1 >= 0 && grid[i - 1][j] == '1') {
                grid[i - 1][j] = 0;
                q.add(new int[]{i - 1, j});
            }
            if(i + 1 < grid.length && grid[i + 1][j] == '1') {
                grid[i + 1][j] = 0;
                q.add(new int[]{i + 1, j});
            }
            if(j - 1 >= 0 && grid[i][j - 1] == '1') {
                grid[i][j - 1] = 0;
                q.add(new int[]{i, j - 1});
            }
            if(j + 1 < grid[0].length && grid[i][j + 1] == '1') {
                grid[i][j + 1] = 0;
                q.add(new int[]{i, j + 1});
            }
        }
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.numIslands(
                new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
        System.out.println(s.numIslands(
                new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}));
    }
}
