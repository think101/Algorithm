package main.com.think101.leetcode.Patterns.BFS.SurroundedRegions;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public void solve(char[][] board) {
        Queue<int[]> q = new LinkedList<>();
        int row = board.length, col = board[0].length;

        for(int i = 0; i < row; i++){
            if(board[i][0] == 'O') {
                q.add(new int[]{i, 0});
                board[i][0] = 'M';
            }

            if(board[i][col - 1] == 'O') {
                q.add(new int[]{i, col - 1});
                board[i][col - 1] = 'M';
            }
        }

        for(int j = 0; j < col; j++){
            if(board[0][j] == 'O') {
                q.add(new int[]{0, j});
                board[0][j] = 'M';
            }

            if(board[row - 1][j] == 'O') {
                q.add(new int[]{row - 1, j});
                board[row - 1][j] = 'M';
            }
        }

        while(q.size() > 0) {
            int[] pos = q.poll();
            int i = pos[0], j = pos[1];

            if(i - 1 >= 0 && board[i - 1][j] == 'O') {board[i - 1][j] = 'M'; q.add(new int[]{i - 1, j});}
            if(i + 1 < row && board[i + 1][j] == 'O') {board[i + 1][j] = 'M'; q.add(new int[]{i + 1, j});}
            if(j - 1 >= 0 && board[i][j - 1] == 'O') {board[i][j - 1] = 'M'; q.add(new int[]{i, j - 1});}
            if(j + 1 < col && board[i][j + 1] == 'O') {board[i][j + 1] = 'M'; q.add(new int[]{i, j + 1});}
        }

        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(board[i][j] == 'M') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        char[][] board = new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        s.print(board);
        s.solve(board);
        System.out.println();
        s.print(board);
    }

    private void print(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
