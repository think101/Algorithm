package main.com.think101.leetcode.Patterns.DFS.SurroundedRegions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public void solve(char[][] board) {
        Set<int[]> visited = new HashSet<>();
        List<int[]> os = new ArrayList<>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    os.add(new int[]{i, j});
                }
            }
        }

        for(int[] node : os){
            if(visited.contains(node))
                continue;

            Set<int[]> current = new HashSet<>();
            boolean captured = dfs(node[0], node[1], visited, current, board);

            if(captured) {
                for(int[] c : current) {
                    board[c[0]][c[1]] = 'X';
                }
            }
        }

    }

    private boolean dfs(int i, int j, Set<int[]> visited, Set<int[]> current, char[][] board) {
        int row = board.length, col = board[0].length;
        boolean res = i != 0 && i != row - 1 && j != 0 && j != col - 1;

        visited.add(new int[]{i, j});
        current.add(new int[]{i, j});

        if(i-1 >= 0 && board[i-1][j] == 'O' && !visited.contains(new int[]{i-1, j}))
            if(!dfs(i-1, j, visited, current, board))
                res = false;
        if(i+1 < row && board[i+1][j] == 'O' && !visited.contains(new int[]{i+1, j}))
            if(!dfs(i+1, j, visited, current, board))
                res = false;
        if(j-1 >= 0 && board[i][j-1] == 'O' && !visited.contains(new int[]{i, j-1}))
            if(!dfs(i, j-1, visited, current, board))
                res = false;
        if(j+1 < col && board[i][j+1] == 'O' && !visited.contains(new int[]{i, j+1}))
            if(!dfs(i, j+1, visited, current, board))
                res = false;

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
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