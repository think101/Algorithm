package main.com.think101.leetcode.Patterns.BFS.MinHeightTrees;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n <= 2) return IntStream.rangeClosed(0, n-1).boxed().collect(Collectors.toList());

        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for(int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for(int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i : graph.keySet()) {
            if(graph.get(i).size() == 1) {
                queue.add(i);
            }
        }

        while(graph.size() > 2) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int t = queue.poll();
                for(int neighbor : graph.get(t)) {
                    if (graph.containsKey(neighbor)) {
                        graph.get(neighbor).remove(t);
                        if(graph.get(neighbor).size() == 1) {
                            queue.add(neighbor);
                        }
                    }
                }

                graph.remove(t);
            }
        }

        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMinHeightTrees(6, new int[][] {{0,1},{0,2},{0,3}, {3,4}, {4,5}}));
    }
}
