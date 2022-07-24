package main.com.think101.leetcode.Patterns.BackTrack.WordSearch;

class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(dfs(i, j, 0, board, word))
                    return true;
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, int ind, char[][] board, String word) {
        if(board[i][j] != word.charAt(ind)){
            return false;
        }

        board[i][j] = '0';

        if(ind == word.length() - 1
                || (i - 1 >= 0 && dfs(i-1, j, ind+1, board, word))
                || (i + 1 < board.length && dfs(i+1, j, ind+1, board, word))
                || (j - 1 >= 0 && dfs(i, j-1, ind+1, board, word))
                || (j + 1 < board[0].length && dfs(i, j+1, ind+1, board, word))) {
            return true;
        }

        board[i][j] = word.charAt(ind);
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(s.exist(board, "ABCCED"));

        board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(s.exist(board, "SEE"));

        board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(s.exist(board, "ABCB"));
    }
}
