package main.com.think101.leetcode.ValidSudoku;

public class Solution {

    public boolean isValidSudoku(char[][] board) {
        return checkRow(board) && checkColumn(board) && checkSubGrid(board);
    }

    private boolean checkRow(char[][] board) {
        for(int i=0; i<9; i++) {
            int[] filled = new int[9];

            for(int j=0; j<9; j++) {
                if(board[i][j] != '.') {
                    if(filled[board[i][j]-'1'] > 0)
                        return false;
                    else
                        filled[board[i][j]-'1']++;
                }
            }
        }

        return true;
    }

    private boolean checkColumn(char[][] board) {
        for(int i=0; i<9; i++) {
            int[] filled = new int[9];

            for(int j=0; j<9; j++) {
                if(board[j][i] != '.') {
                    if(filled[board[j][i]-'1'] > 0)
                        return false;
                    else
                        filled[board[j][i]-'1']++;
                }
            }
        }

        return true;
    }

    private boolean checkSubGrid(char[][] board) {
        int[][] subGrids = new int[][]{
                {1,1},{1,4},{1,7},
                {4,1},{4,4},{4,7},
                {7,1},{7,4},{7,7}
        };
        for(int[] grid : subGrids) {
            int[] filled = new int[9];

            for(int i=grid[0]-1; i<=grid[0]+1; i++) {
                for(int j=grid[1]-1; j<=grid[1]+1; j++){
                    if(board[i][j] != '.') {
                        if(filled[board[i][j]-'1'] > 0)
                            return false;
                        else
                            filled[board[i][j]-'1']++;
                    }
                }
            }
        }

        return true;
    }
}
