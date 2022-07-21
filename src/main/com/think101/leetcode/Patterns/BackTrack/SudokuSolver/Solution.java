package main.com.think101.leetcode.Patterns.BackTrack.SudokuSolver;

import java.util.*;


class Solution {
    Map<Integer, Set<Character>> rows = new HashMap<>();
    Map<Integer, Set<Character>> cols = new HashMap<>();
    Map<List<Integer>, Set<Character>> subs = new HashMap<>();

    public void solveSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(!rows.containsKey(i))
                    rows.put(i, new HashSet<>());
                if(!cols.containsKey(j))
                    cols.put(j, new HashSet<>());

                List<Integer> p = Arrays.asList(i/3, j/3);
                if(!subs.containsKey(p))
                    subs.put(p, new HashSet<>());

                if(board[i][j] != '.'){
                    rows.get(i).add(board[i][j]);
                    cols.get(j).add(board[i][j]);
                    subs.get(p).add(board[i][j]);
                }
            }
        }

        backtrack(0, 0, board);
    }

    private boolean backtrack(int i, int j, char[][] board) {
        if(i == 9)
            return true;

        if(board[i][j] != '.') {
            return backtrack(j < 8 ? i : i+1, j < 8 ? j+1 : 0, board);
        }

        List<Integer> p = Arrays.asList(i/3, j/3);
        for(int k = 1; k <= 9; k++) {
            char c = (char)('0' + k);
            if(rows.get(i).contains(c) || cols.get(j).contains(c) || subs.get(p).contains(c)) {
                continue;
            }

            rows.get(i).add(c);
            cols.get(j).add(c);
            subs.get(p).add(c);
            board[i][j] = c;

            if(backtrack(j < 8 ? i : i+1, j < 8 ? j+1 : 0, board))
                return true;

            rows.get(i).remove(c);
            cols.get(j).remove(c);
            subs.get(p).remove(c);
            board[i][j] = '.';
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
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
        Solution sol = new Solution();
        sol.solveSudoku(board);
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
