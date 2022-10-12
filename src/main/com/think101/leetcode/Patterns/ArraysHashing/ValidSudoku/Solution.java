package main.com.think101.leetcode.Patterns.ArraysHashing.ValidSudoku;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            if(!checkLine(i, board))
                return false;
            if(!checkColumn(i, board))
                return false;
        }

        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++)
                if(!checkBox(i, j, board))
                    return false;

        return true;

    }

    private boolean checkLine(int i, char[][] board) {
        int[] t = new int[10];
        for(int j = 0; j < 9; j++){
            if(board[i][j] != '.' )
                if(t[board[i][j] - '0'] > 0)
                    return false;
                else
                    t[board[i][j] - '0'] += 1;
        }

        return true;
    }

    private boolean checkColumn(int i, char[][] board) {
        int[] t = new int[10];
        for(int j = 0; j < 9; j++){
            if(board[j][i] != '.' )
                if (t[board[j][i] - '0'] > 0)
                    return false;
                else
                    t[board[j][i] - '0'] += 1;
        }

        return true;
    }

    private boolean checkBox(int i, int j, char[][] board) {
        int[] t = new int[10];
        for(int a = i * 3; a < i * 3 + 3; a++){
            for(int b = j * 3; b < j * 3 + 3; b++) {
                if(board[a][b] != '.')
                    if(t[board[a][b] - '0'] > 0)
                        return false;
                    else
                        t[board[a][b] - '0'] += 1;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = new char[][]{
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(s.isValidSudoku(board));
    }
}
