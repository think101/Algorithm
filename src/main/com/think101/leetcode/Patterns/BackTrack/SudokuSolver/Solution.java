package main.com.think101.leetcode.Patterns.BackTrack.SudokuSolver;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


class Solution {
    Map<Integer, Set<Character>> rows = new HashMap<>();
    Map<Integer, Set<Character>> cols = new HashMap<>();
    Map<Pair<Integer, Integer>, Set<Character>> subs = new HashMap<>();

    public void solveSudoku(char[][] board) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(!rows.containsKey(i))
                    rows.put(i, new HashSet<Character>());
                if(!cols.containsKey(j))
                    cols.put(j, new HashSet<Character>());

                Pair<Integer, Integer> p = new Pair(i/3, j/3);
                if(!subs.containsKey(p))
                    subs.put(p, new HashSet<Character>());

                if(board[i][j] != '.'){
                    rows.get(i).add(board[i][j]);
                    cols.get(j).add(board[i][j]);
                    subs.get(p).add(board[i][j]);
                }
            }
        }

        if(backtrack(0, 0, board))
            return;
    }

    private boolean backtrack(int i, int j, char[][] board) {
        if(i == 9)
            return true;

        if(board[i][j] != '.') {
            return backtrack(j < 8 ? i : i+1, j < 8 ? j+1 : 0, board);
        }

        Pair<Integer, Integer> p = new Pair(i/3, j/3);
        for(int k = 1; k <= 9; k++) {
            char c = (char)('0' + k);
            if(rows.get(i).contains(c) || cols.get(j).contains(c) || subs.get(p).contains(c)) {
                continue;
            }

            rows.get(i).add(c);
            cols.get(j).add(c);
            subs.get(p).add(c);
            board[i][j] = c;

            if(j < 8) {
                j++;
            }
            else {
                i++;
                j = 0;
            }

            if(backtrack(j < 8 ? i : i+1, j < 8 ? j+1 : 0, board))
                return true;

            rows.get(i).remove(c);
            cols.get(j).remove(c);
            subs.get(p).remove(c);
            board[i][j] = '.';
        }

        return false;
    }
}
