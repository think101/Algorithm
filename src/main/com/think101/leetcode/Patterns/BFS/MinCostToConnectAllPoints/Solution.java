package main.com.think101.leetcode.Patterns.BFS.MinCostToConnectAllPoints;

import java.util.*;

public class Solution {
    private Set<Integer> visited = new HashSet<>();
    private PriorityQueue<int[]> edgeByCost = new PriorityQueue<>(10, Comparator.comparingInt(a -> a[0]));
    private int cost = 0;

    public int minCostConnectPoints(int[][] points) {
        edgeByCost.add(new int[]{0, 0});

        while(visited.size() < points.length) {
            int[] t = edgeByCost.poll();
            if(visited.contains(t[1])) continue; // already visited

            visited.add(t[1]);
            cost += t[0];
            for(int i = 0; i < points.length; i++) {
                if(!visited.contains(i)) {
                    edgeByCost.add(new int[]{
                            Math.abs(points[i][0] - points[t[1]][0]) + Math.abs(points[i][1] - points[t[1]][1]),
                            i});
                }
            }
        }

        return cost;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] points = new int[][]{{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println(s.minCostConnectPoints(points));
    }
}

/*
    * This is a implementation of Prim's algorithm
    * it's not hard to think of using a min heap to store the edges, though throughly think of the whole
    * prim's algorithm is not easy
 */