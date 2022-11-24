package main.com.think101.leetcode.Patterns.BackTrack.WordSearch;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, word, 0, i, j, new ArrayList<>())){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int ind, int i, int j, List<int[]> visited) {
        if(ind == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if(board[i][j] != word.charAt(ind)) return false;

        visited.add(new int[]{i, j});
        if(!visited.contains(new int[]{i-1, j}) && dfs(board, word, ind+1, i - 1, j, visited)) return true;
        if(!visited.contains(new int[]{i+1, j}) && dfs(board, word, ind+1, i + 1, j, visited)) return true;
        if(!visited.contains(new int[]{i, j-1}) && dfs(board, word, ind+1, i, j - 1, visited)) return true;
        if(!visited.contains(new int[]{i, j+1}) && dfs(board, word, ind+1, i, j + 1, visited)) return true;
        visited.remove(visited.size() - 1);

        return false;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        char[][] board = {
                {'A','B','C','E'}

        };
        System.out.println(s.exist(board, "ABCB"));
    }
}
