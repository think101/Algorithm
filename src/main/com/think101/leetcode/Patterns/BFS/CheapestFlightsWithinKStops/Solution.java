package main.com.think101.leetcode.Patterns.BFS.CheapestFlightsWithinKStops;

import java.util.*;

public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> neighbors = new HashMap<>();

        int[] dist = new int[n];
        for(int i = 0; i < n; i++) dist[i] = Integer.MAX_VALUE;

        for(int[] f : flights) {
            if(!neighbors.containsKey(f[0])) {
                neighbors.put(f[0], new ArrayList<>());
            }

            neighbors.get(f[0]).add(new int[]{f[1], f[2]});
        }

        int stop = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{src, 0});

        while(stop <= k && queue.size() > 0) {
            stop++;
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int[] node = queue.poll();

                if(neighbors.containsKey(node[0])) {
                    for(int[] neigh : neighbors.get(node[0])) {
                        int cost = node[1] + neigh[1];

                        if(cost >= dist[neigh[0]]) continue;

                        dist[neigh[0]] = cost;
                        queue.add(new int[]{neigh[0], cost});
                    }
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] flights = new int[][]{{0,1,100},{1,2,100},{0,2,500}};
        System.out.println(s.findCheapestPrice(3, flights, 0, 2, 1));
    }
}

/*
 * In this solution, it's not required to have a visited array, use a visited array may generate wrong answer.
 * For example if src has neighbor a and neighbor b, while b has neighbor a, if we use a visited array, we will not visit a again.
 * But we should visit a again, because we can get a cheaper price.
 *
 * Though we need an array to store the cost from src to each node, and the array will be updated when we visit a node.
 * Each node's cost may be updated multiple times, but the final cost will be the minimum cost.
 */
