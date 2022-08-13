package main.com.think101.leetcode.Patterns.BFS.MinHeightTrees;

import java.util.*;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        TreeMap<Integer, List<Integer>> heightToNode = new TreeMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();

        for(int[] edge : edges) {
            if(!graph.containsKey(edge[0])){
                graph.put(edge[0], new ArrayList<Integer>());
            }
            graph.get(edge[0]).add(edge[1]);

            if(!graph.containsKey(edge[1])){
                graph.put(edge[1], new ArrayList<Integer>());
            }
            graph.get(edge[1]).add(edge[0]);
        }


        for(int i = 0; i < n; i++) {
            Queue<Integer> q = new LinkedList<>();
            q.add(i);

            Set<Integer> visited = new HashSet<>();

            int depth = 0;
            while(q.size() > 0) {
                depth++;

                int cnt = q.size();
                for(int j = 0; j < cnt; j++) {
                    int t = q.poll();

                    if(visited.contains(t))
                        continue;

                    visited.add(t);
                    if(graph.containsKey(t)) {
                        for(int k : graph.get(t))
                            if(!visited.contains(k))
                                q.add(k);
                    }
                }
            }

            if(!heightToNode.containsKey(depth)){
                heightToNode.put(depth, new ArrayList<Integer>());
            }

            heightToNode.get(depth).add(i);
        }

        return heightToNode.firstEntry().getValue();
    }
}
