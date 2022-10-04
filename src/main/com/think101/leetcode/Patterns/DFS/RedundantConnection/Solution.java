package main.com.think101.leetcode.Patterns.DFS.RedundantConnection;

import java.util.*;

public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();

        for(int[] edge : edges){
            if(!graph.containsKey(edge[0])) {
                graph.put(edge[0], new HashSet<>());
            }
            if(!graph.containsKey(edge[1])) {
                graph.put(edge[1], new HashSet<>());
            }

            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        for(int i = edges.length - 1; i >= 0; i--) {
            int[] e = edges[i];

            graph.get(e[0]).remove(e[1]);
            graph.get(e[1]).remove(e[0]);
            if(connect(e[0], e[1], graph, new HashSet<>())) return e;
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        return null;

    }

    private boolean connect(int i, int j, Map<Integer, Set<Integer>> graph, Set<Integer> visited) {
        if(!graph.containsKey(i) || !graph.containsKey(j) || visited.contains(i)) return false;
        if(graph.get(i).contains(j) || graph.get(j).contains(i)) return true;

        visited.add(i);
        for(int neighbor : graph.get(i)) {
            if(connect(neighbor, j, graph, visited))
                return true;
        }
        visited.remove(i);

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.findRedundantConnection(
                new int[][]{{1,2},{1,3},{2,3}})));
        System.out.println(Arrays.toString(s.findRedundantConnection(
                new int[][]{{1,2},{2,3},{3,4},{1,4},{1,5}})));
    }
}
