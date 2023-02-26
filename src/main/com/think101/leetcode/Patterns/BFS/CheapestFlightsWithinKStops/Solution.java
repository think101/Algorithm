package main.com.think101.leetcode.Patterns.BFS.CheapestFlightsWithinKStops;

import java.util.*;

public class Solution {
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

        int stop = 0;
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(new int[]{src, 0});
        visited.add(src);

        while(stop <= k && queue.size() > 0) {
            stop++;

            for(int i = 0; i < queue.size(); i++) {
                int[] node = queue.poll();

                if(neighbors.containsKey(node[0])) {
                    for(int neigh : neighbors.get(node[0])) {
                        if(visited.contains(neigh)) continue;
                        int cost = node[1] + edgeCost.get(Arrays.asList(node[0], neigh));

                        if(neigh == dst) {
                            if(res == -1 || res > cost) res = cost;
                        }
                        else {
                            queue.add(new int[]{neigh, cost});
                        }
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] flights = new int[][]{{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(s.findCheapestPrice(3, flights, 0, 2, 1));
    }
}
