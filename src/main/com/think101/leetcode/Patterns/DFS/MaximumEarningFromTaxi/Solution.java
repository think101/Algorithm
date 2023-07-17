package main.com.think101.leetcode.Patterns.DFS.MaximumEarningFromTaxi;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

class Solution {
    TreeMap<Integer, List<int[]>> startToEnds = new TreeMap<>();
    TreeMap<Integer, Integer> maxEarnAtPos = new TreeMap<>();
    int res = Integer.MIN_VALUE;

    public long maxTaxiEarnings(int[][] rides) {
        findStartToEnds(rides);

        Set<Integer> kSet = startToEnds.descendingKeySet();
        for(Integer key : kSet) {
            int r = Integer.MIN_VALUE;
            for(int[] ride : startToEnds.get(key)) {
                r = Math.max(r, ride[1] - ride[0] + ride[2] + helper(ride[1]));
            }

            res = Math.max(res, r);
            maxEarnAtPos.put(key, r);
        }

        return res;
    }

    private void findStartToEnds(int[][] rides) {
        for(int[] ride : rides) {
            if(!startToEnds.containsKey(ride[0])) {
                startToEnds.put(ride[0], new ArrayList<>());
            }

            startToEnds.get(ride[0]).add(ride);
        }
    }

    private int helper(int start) {
        int r = Integer.MIN_VALUE;

        if(maxEarnAtPos.containsKey(start)) {
            r = maxEarnAtPos.get(start);
        }

        Integer hKey = maxEarnAtPos.higherKey(start);
        while(hKey != null) {
            r = Math.max(r, maxEarnAtPos.get(hKey));
            hKey = maxEarnAtPos.higherKey(hKey);
        }

        r = r == Integer.MIN_VALUE ? 0 : r;
        maxEarnAtPos.put(start, r);

        return r;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] rides = new int[][]{{1,6,1},{3,10,2},{10,12,3},{11,12,2},{12,15,2},{13,18,1}};
        System.out.println(s.maxTaxiEarnings(rides));
    }
}
