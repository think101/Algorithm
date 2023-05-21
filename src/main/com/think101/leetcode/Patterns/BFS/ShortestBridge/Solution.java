package main.com.think101.leetcode.Patterns.BFS.ShortestBridge;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int[][] visited = new int[n][n];

        // find all the nodes in 1 island
        Queue<int[]> nodes = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    visited[i][j] = 1;

                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    while(q.size() > 0) {
                        int[] node = q.poll();

                        nodes.add(node);
                        int a = node[0], b = node[1];
                        if(a - 1 >= 0 && grid[a - 1][b] == 1 && visited[a - 1][b] == 0) {
                            q.add(new int[]{a - 1, b});
                            visited[a - 1][b] = 1;
                        }
                        if(a + 1 < n && grid[a + 1][b] == 1 && visited[a + 1][b] == 0) {
                            q.add(new int[]{a + 1, b});
                            visited[a + 1][b] = 1;
                        }
                        if(b - 1 >= 0 && grid[a][b - 1] == 1 && visited[a][b - 1] == 0) {
                            q.add(new int[]{a, b - 1});
                            visited[a][b - 1] = 1;
                        }
                        if(b + 1 < n && grid[a][b + 1] == 1 && visited[a][b + 1] == 0) {
                            q.add(new int[]{a, b + 1});
                            visited[a][b + 1] = 1;
                        }
                    }

                    break;
                }
            }
        }

        visited = new int[n][n];
        int k = 0;
        while(nodes.size() > 0) {
            int size = nodes.size();
            k++;

            for(int i = 0; i < size; i++) {
                int[] node = nodes.poll();
                int a = node[0], b = node[1];

                visited[a][b] = 1;
                if(a - 1 >= 0 && visited[a - 1][b] == 0) {
                    if(grid[a - 1][b] == 1) break;
                    else nodes.add(new int[]{a - 1, b});
                }
                if(a + 1 < n && visited[a + 1][b] == 0) {
                    if(grid[a + 1][b] == 1) break;
                    else nodes.add(new int[]{a + 1, b});
                }
                if(b - 1 >= 0 && visited[a][b - 1] == 0) {
                    if(grid[a][b - 1] == 1) break;
                    else nodes.add(new int[]{a, b - 1});
                }
                if(b + 1 < n && visited[a][b + 1] == 0) {
                    if(grid[a][b + 1] == 1) break;
                    else nodes.add(new int[]{a, b + 1});
                }
            }
        }

        return k;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid = {{0, 1}, {1, 0}};
        System.out.println(s.shortestBridge(grid));
    }
}
