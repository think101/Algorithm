package main.com.think101.leetcode.Patterns.BFS.NumOfIslands;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SolutionTLE {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int res = 0;

        List<int[]> onePosList = new ArrayList<>();
        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++)
                if(grid[i][j] == '1')
                    onePosList.add(new int[]{i, j});

        for(int[] pos : onePosList) {
            int i = pos[0], j = pos[1];
            if(grid[i][j] == '1') {
                res++;

                Queue<int[]> queue = new LinkedList<>();
                queue.add(pos);

                while(queue.size() > 0) {
                    int[] node = queue.poll();
                    int x = node[0], y = node[1];
                    grid[x][y] = '0';

                    if(x - 1 >=0 && grid[x - 1][y] == '1') queue.add(new int[]{x - 1, y});
                    if(x + 1 < row && grid[x + 1][y] == '1') queue.add(new int[]{x + 1, y});
                    if(y - 1 >= 0 && grid[x][y - 1] == '1') queue.add(new int[]{x, y - 1});
                    if(y + 1 < col && grid[x][y + 1] == '1') queue.add(new int[]{x, y + 1});
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SolutionTLE s = new SolutionTLE();
        System.out.println(s.numIslands(
                new char[][]{{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));
        System.out.println(s.numIslands(
                new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}));
    }
}
