package main.com.think101.leetcode.Patterns.BFS.ShortestBridge;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        boolean found = false;

        // Find the first island and mark all its nodes as visited
        for (int i = 0; i < n; i++) {
            if (found) break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, directions);
                    found = true;
                    break;
                }
            }
        }

        // Traverse the second island using BFS
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];

        // Add all the nodes of the first island to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
                int x = node[0], y = node[1];

                for (int[] direction : directions) {
                    int nx = x + direction[0];
                    int ny = y + direction[1];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                        if (grid[nx][ny] == 1) {
                            return steps;
                        } else {
                            queue.add(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
            steps++;
        }

        return steps;
    }

    // DFS to mark all nodes of the first island as visited
    private void dfs(int[][] grid, int x, int y, int[][] directions) {
        int n = grid.length;
        if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] != 1) {
            return;
        }

        grid[x][y] = 2; // Mark the node as visited

        for (int[] direction : directions) {
            int nx = x + direction[0];
            int ny = y + direction[1];
            dfs(grid, nx, ny, directions);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{0, 1}, {1, 0}};
        System.out.println(s.shortestBridge(grid));

        grid = new int[][]{{0, 1, 0}, {0, 0, 0}, {0, 0, 1}};
        System.out.println(s.shortestBridge(grid));

        grid = new int[][]{{1, 1, 1, 1, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}};
        System.out.println(s.shortestBridge(grid));
    }
}
