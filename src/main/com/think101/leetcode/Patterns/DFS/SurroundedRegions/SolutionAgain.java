package main.com.think101.leetcode.Patterns.DFS.SurroundedRegions;

import java.util.ArrayList;
import java.util.List;

public class SolutionAgain {
    public void solve(char[][] board) {
        int row = board.length, col = board[0].length;
        List<int[]> edgeOs = new ArrayList<>();

        for(int i = 0; i < row; i++){
            if(board[i][0] == 'O')
                edgeOs.add(new int[]{i, 0});
            if(board[i][col-1] == 'O')
                edgeOs.add(new int[]{i, col-1});
        }

        for(int j = 0; j < col; j++){
            if(board[0][j] == 'O')
                edgeOs.add(new int[]{0, j});
            if(board[row-1][j] == 'O')
                edgeOs.add(new int[]{row-1, j});
        }

        for(int[] p : edgeOs){
            dfs(p[0], p[1], board);
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 'M') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if(board[i][j] != 'O') return;

        board[i][j] = 'M';
        dfs(i-1, j, board);
        dfs(i+1, j, board);
        dfs(i, j-1, board);
        dfs(i, j+1, board);
    }

    public static void main(String[] args) {
        SolutionAgain s = new SolutionAgain();
        char[][] board = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        s.solve(board);
        for(char[] row : board) {
            for(char c : row)
                System.out.print(c);
            System.out.println();
        }
    }
}
