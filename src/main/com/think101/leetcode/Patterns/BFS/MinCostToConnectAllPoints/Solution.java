package main.com.think101.leetcode.Patterns.BFS.MinCostToConnectAllPoints;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    private List<Integer> visited = new ArrayList<>();
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
