package main.com.think101.leetcode.Patterns.BackTrack.WordSearch;

public class Solution2 {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i ++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(board, word, 0, i, j)){
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int ind, int i, int j) {
        if(ind == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return false;
        if(board[i][j] != word.charAt(ind)) return false;

        char c = board[i][j];
        board[i][j] = '0';
        if(dfs(board, word, ind+1, i - 1, j)) return true;
        if(dfs(board, word, ind+1, i + 1, j)) return true;
        if(dfs(board, word, ind+1, i, j - 1)) return true;
        if(dfs(board, word, ind+1, i, j + 1)) return true;
        board[i][j] = c;

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
