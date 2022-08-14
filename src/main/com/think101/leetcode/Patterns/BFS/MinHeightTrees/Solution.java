package main.com.think101.leetcode.Patterns.BFS.MinHeightTrees;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n <= 2) return IntStream.rangeClosed(0, n-1).boxed().collect(Collectors.toList());

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> degrees = new HashMap<>();

        for(int[] edge : edges) {
            if(!graph.containsKey(edge[0])){
                graph.put(edge[0], new ArrayList<>());
            }
            graph.get(edge[0]).add(edge[1]);

            if(!graph.containsKey(edge[1])){
                graph.put(edge[1], new ArrayList<>());
            }
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i : graph.keySet()) {
            if(graph.get(i).size() == 1) {
                queue.add(i);
            }

            degrees.put(i, graph.get(i).size());
        }

        while(queue.size() > 0) {
            if(degrees.size() <= 2) {
                break;
            }

            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int t = queue.poll();
                degrees.remove(t);
                for(int neighbor : graph.get(t)) {
                    if (degrees.containsKey(neighbor)) {
                        degrees.put(neighbor, degrees.get(neighbor) - 1);
                        if(degrees.get(neighbor) == 1) {
                            queue.add(neighbor);
                        }
                    }
                }
            }
        }

        return new ArrayList<>(degrees.keySet());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findMinHeightTrees(6, new int[][] {{0,1},{0,2},{0,3}, {3,4}, {4,5}}));
    }
}
