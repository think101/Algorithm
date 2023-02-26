package main.com.think101.leetcode.Patterns.BFS.CheapestFlightsWithinKStops;

import java.util.*;

public class SolutionDFS {
    int res = -1;
    Map<List<Integer>, Integer> edgeCost = new HashMap<>();
    Map<Integer, List<Integer>> neighbors = new HashMap<>();

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        for(int[] f : flights) {
            if(!neighbors.containsKey(f[0])) {
                neighbors.put(f[0], new ArrayList<>());
            }

            neighbors.get(f[0]).add(f[1]);
            edgeCost.put(Arrays.asList(f[0], f[1]), f[2]);
        }

        dfs(src, dst, k, new ArrayList<>(), 0);

        return res;
    }

    private void dfs(int n, int dst, int k, List<Integer> visited, int cost) {
        int c = visited.size() > 0 ? edgeCost.get(Arrays.asList(visited.get(visited.size() - 1), n)) : 0;

        if(n == dst && visited.size() <= 1 + k) {
            if(res == -1 || res > (cost + c)) {
                res = cost + c;
            }

            return;
        }
        else if(visited.size() > (1 + k)) {
            return;
        }

        visited.add(n);
        if(neighbors.containsKey(n)) {
            for(int neighbor : neighbors.get(n)) {
                if(!visited.contains(neighbor)) {
                    dfs(neighbor, dst, k, visited, cost + c);
                }
            }
        }
        visited.remove(visited.size() - 1);
    }

    public static void main(String[] args) {
        SolutionDFS s = new SolutionDFS();
        int[][] flights = new int[][]{{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(s.findCheapestPrice(3, flights, 0, 2, 1));
    }
}
