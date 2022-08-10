package main.com.think101.leetcode.Patterns.BFS.SurroundedRegions;

import java.util.*;

public class Solution {
    public void solve(char[][] board) {
        Set<List<Integer>> visited = new HashSet<>();
        List<List<Integer>> oAtEdges = new ArrayList<>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'O' && (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1)){
                    oAtEdges.add(Arrays.asList(i, j));
                }
            }
        }

        for(List<Integer> node : oAtEdges){
            Queue<List<Integer>> q = new LinkedList<>();
            q.add(node);

            while(q.size() > 0) {
                List<Integer> n = q.poll();

                if(board[n.get(0)][n.get(1)] != 'O') {
                    continue;
                }

                int i = n.get(0), j = n.get(1);
                board[i][j] = 'M';
                visited.add(n);

                if(i-1 >= 0 && board[i-1][j] == 'O' && !visited.contains(Arrays.asList(i-1, j))) q.add(Arrays.asList(i-1, j));
                if(i+1 < board.length && board[i+1][j] == 'O' && !visited.contains(Arrays.asList(i+1, j))) q.add(Arrays.asList(i+1, j));
                if(j-1 >= 0 && board[i][j-1] == 'O' && !visited.contains(Arrays.asList(i, j-1))) q.add(Arrays.asList(i, j-1));
                if(j+1 < board[0].length && board[i][j+1] == 'O' && !visited.contains(Arrays.asList(i, j+1))) q.add(Arrays.asList(i, j+1));
            }

        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'M') board[i][j] = 'O';
                else if(board[i][j] == 'O') board[i][j] = 'X';
            }
        }
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