package main.com.think101.leetcode.Patterns.BFS.NumOfIslands;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public int numIslands(char[][] grid) {
        List<int[]> ones = new ArrayList<>();
        int row = grid.length, col = grid[0].length;
        int res = 0;

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++)
                if(grid[i][j] == '1')
                    ones.add(new int[]{i, j});
        }

        for(int[] one : ones) {
            if(grid[one[0]][one[1]] != '1')
                continue;

            res++;
            Queue<int[]> q = new LinkedList<>();
            q.add(one);

            while(q.size() > 0){
                int[] elem = q.poll();
                if(grid[elem[0]][elem[1]] == 'x')
                    continue;

                int i = elem[0], j = elem[1];

                grid[elem[0]][elem[1]] = 'x';
                if(i-1 >= 0 && grid[i-1][j] == '1') q.add(new int[]{i-1, j});
                if(i+1 < row && grid[i+1][j] == '1') q.add(new int[]{i+1, j});
                if(j-1 >= 0 && grid[i][j-1] == '1') q.add(new int[]{i, j-1});
                if(j+1 < col && grid[i][j+1] == '1') q.add(new int[]{i, j+1});
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numIslands(
                new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
        System.out.println(s.numIslands(
                new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}));
    }
}
