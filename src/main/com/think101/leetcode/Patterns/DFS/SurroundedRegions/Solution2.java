package main.com.think101.leetcode.Patterns.DFS.SurroundedRegions;

import java.util.*;

public class Solution2 {
    public void solve(char[][] board) {
        List<List<Integer>> oAtEdges = new ArrayList<>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O' && (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1)){
                    oAtEdges.add(Arrays.asList(i, j));
                }
            }
        }

        for(List<Integer> node : oAtEdges){
            if(board[node.get(0)][node.get(1)] != 'O')
                continue;

            dfs(node.get(0), node.get(1), board);
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == 'M') board[i][j] = 'O';
            }
        }

    }

    private void dfs(int i, int j, char[][] board) {
        int row = board.length, col = board[0].length;

        board[i][j] = 'M';

        if(i-1 >= 0 && board[i-1][j] == 'O') dfs(i-1, j, board);
        if(i+1 < row && board[i+1][j] == 'O') dfs(i+1, j, board);
        if(j-1 >= 0 && board[i][j-1] == 'O') dfs(i, j-1, board);
        if(j+1 < col && board[i][j+1] == 'O') dfs(i, j+1, board);
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
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
