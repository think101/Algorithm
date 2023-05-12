package main.com.think101.leetcode.Patterns.BackTrack.WordSearch;

public class Solution3 {

    public boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(helper(board, visited, word, 0, i, j)) return true;
            }
        }

        return false;
    }

    private boolean helper(char[][] board, int[][] visited, String word, int ind, int i, int j) {
        int row = board.length, col = board[0].length;
        if(ind == word.length()) return true;
        if(i < 0 || i >= row || j < 0 || j >= col) return false;
        if(visited[i][j] == 1 || board[i][j] != word.charAt(ind)) return false;

        visited[i][j] = 1;
        if(helper(board, visited, word, ind + 1, i - 1, j)) return true;
        if(helper(board, visited, word, ind + 1, i + 1, j)) return true;
        if(helper(board, visited, word, ind + 1, i, j - 1)) return true;
        if(helper(board, visited, word, ind + 1, i, j + 1)) return true;

        return false;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
        System.out.println(s.exist(board, "ABCCED"));
    }
}
