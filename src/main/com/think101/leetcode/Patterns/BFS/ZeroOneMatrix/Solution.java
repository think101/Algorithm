package main.com.think101.leetcode.Patterns.BFS.ZeroOneMatrix;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length, col = mat[0].length;
        int[][] visited = new int[row][col];
        Queue<int[]> cells = new LinkedList<>();

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(mat[i][j] == 0) {
                    cells.add(new int[]{i, j});
                    visited[i][j] = 1;
                }
            }
        }

        int d = 1;
        while(cells.size() > 0) {
            int len = cells.size();

            for(int l = 0; l < len; l++) {
                int[] t = cells.poll();
                int i = t[0], j = t[1];

                if(i - 1 >= 0 && visited[i - 1][j] == 0) {
                    mat[i - 1][j] = d;
                    visited[i - 1][j] = 1;
                    cells.add(new int[]{i - 1, j});
                }
                if(i + 1 < row && visited[i + 1][j] == 0) {
                    mat[i + 1][j] = d;
                    visited[i + 1][j] = 1;
                    cells.add(new int[]{i + 1, j});
                }
                if(j - 1 >= 0 && visited[i][j - 1] == 0) {
                    mat[i][j - 1] = d;
                    visited[i][j - 1] = 1;
                    cells.add(new int[]{i, j - 1});
                }
                if(j + 1 < col && visited[i][j + 1] == 0) {
                    mat[i][j + 1] = d;
                    visited[i][j + 1] = 1;
                    cells.add(new int[]{i, j + 1});
                }
            }

            d++;
        }

        return mat;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] mat = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
        int[][] res = s.updateMatrix(mat);
        for(int[] r : res) {
            for(int i : r) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
