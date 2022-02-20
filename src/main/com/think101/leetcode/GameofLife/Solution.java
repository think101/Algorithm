package main.com.think101.leetcode.GameofLife;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        int[][] board = new int[][]{
                {0,1,0},
                {0,0,1},
                {1,1,1},
                {0,0,0}
        };

        gameOfLife(board);
    }


    public static void gameOfLife(int[][] board) {
        List<int[]> liveCells = new ArrayList<>();

        int row = board.length;
        int col = board[0].length;

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                int cnt = countNeighbors(board, i, j);
                if(board[i][j] == 1) {
                    if(cnt == 2 || cnt == 3)
                        liveCells.add(new int[]{i, j});
                }
                else {
                    if(cnt == 3)
                        liveCells.add(new int[]{i, j});
                }
            }
        }

        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                if(isInList(liveCells, new int[]{i,j}))
                    board[i][j] = 1;
                else
                    board[i][j] = 0;
            }
        }
    }

    private static int countNeighbors(int[][] board, int i, int j) {
        int cnt = 0;

        // previous row
        if(i-1 >= 0) {
            if(j-1>=0 && board[i-1][j-1] == 1)
                cnt++;
            if(board[i-1][j] == 1)
                cnt++;
            if(j+1<board[i].length && board[i-1][j+1] == 1)
                cnt++;
        }

        //current row
        if(j-1>=0 && board[i][j-1] == 1)
            cnt++;
        if(j+1<board[i].length && board[i][j+1] == 1)
            cnt++;

        // next row
        if(i+1 < board.length) {
            if(j-1>=0 && board[i+1][j-1] == 1)
                cnt++;
            if(board[i+1][j] == 1)
                cnt++;
            if(j+1<board[i].length && board[i+1][j+1] == 1)
                cnt++;
        }

        return cnt;
    }

    private static boolean isInList(List<int[]> list, int[] target) {
        return list.stream().anyMatch(a -> Arrays.equals(a, target));
    }
}
