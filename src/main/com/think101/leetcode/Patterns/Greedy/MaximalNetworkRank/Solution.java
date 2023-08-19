package main.com.think101.leetcode.Patterns.Greedy.MaximalNetworkRank;

import java.util.*;

public class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        if(roads.length <= 1) return roads.length;

        Map<Integer, Set<Integer>> neighbors = new HashMap<>();
        TreeMap<Integer, Set<Integer>> countToCity = new TreeMap<>(Collections.reverseOrder());

        for(int[] r : roads) {
            if(!neighbors.containsKey(r[0])) {
                neighbors.put(r[0], new HashSet<>());
            }
            if(!neighbors.containsKey(r[1])) {
                neighbors.put(r[1], new HashSet<>());
            }

            neighbors.get(r[0]).add(r[1]);
            neighbors.get(r[1]).add(r[0]);
        }

        for(int c : neighbors.keySet()){
            int cnt = neighbors.get(c).size();

            if(!countToCity.containsKey(cnt)) countToCity.put(cnt, new HashSet<>());
            countToCity.get(cnt).add(c);
        }

        int k0 = -1, k1 = -1;
        int i = 0;
        for(int cnt : countToCity.keySet()) {
            if(i == 0) k0 = cnt;
            else if(i == 1) k1 = cnt;
            else break;
            i++;
        }
        if(countToCity.get(k0).size() > 1) k1 = k0;

        for(int c : countToCity.get(k0)) {
            for(int cc : countToCity.get(k1)) {
                if(cc == c) continue;
                if(!neighbors.get(c).contains(cc)) return k0 + k1;
            }
        }

        return k0 + k1 - 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maximalNetworkRank(5, new int[][]{{0,1},{0,3},{1,2},{1,3},{2,3},{2,4}}));
    }
}
