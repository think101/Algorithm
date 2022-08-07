package main.com.think101.leetcode.Patterns.DFS.SurroundedRegions;

import java.util.*;

public class Solution {
    public void solve(char[][] board) {
        /*
         * Should not use Set<int[]> here, since Arrays don't override equals() and hashCode()
         * implemented in Object class, and therefor two arrays a1 and a2 will be considered equal by HashSet only
         * if a1==a2.
         */
        Set<List<Integer>> visited = new HashSet<>();
        List<List<Integer>> os = new ArrayList<>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O'){
                    os.add(Arrays.asList(i, j));
                }
            }
        }

        for(List<Integer> node : os){
            if(visited.contains(node))
                continue;

            Set<List<Integer>> current = new HashSet<>();
            boolean captured = dfs(node.get(0), node.get(1), visited, current, board);

            if(captured) {
                for(List<Integer> c : current) {
                    board[c.get(0)][c.get(1)] = 'X';
                }
            }
        }

    }

    private boolean dfs(int i, int j, Set<List<Integer>> visited, Set<List<Integer>> current, char[][] board) {
        int row = board.length, col = board[0].length;
        boolean res = i != 0 && i != row - 1 && j != 0 && j != col - 1;

        visited.add(Arrays.asList(i, j));
        current.add(Arrays.asList(i, j));

        if(i-1 >= 0 && board[i-1][j] == 'O' && !visited.contains(Arrays.asList(i-1, j)))
            if(!dfs(i-1, j, visited, current, board))
                res = false;
        if(i+1 < row && board[i+1][j] == 'O' && !visited.contains(Arrays.asList(i+1, j)))
            if(!dfs(i+1, j, visited, current, board))
                res = false;
        if(j-1 >= 0 && board[i][j-1] == 'O' && !visited.contains(Arrays.asList(i, j-1)))
            if(!dfs(i, j-1, visited, current, board))
                res = false;
        if(j+1 < col && board[i][j+1] == 'O' && !visited.contains(Arrays.asList(i, j+1)))
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