package main.com.think101.leetcode.Patterns.DFS.MaximumLengthOfPairChain;

import java.util.*;

public class Solution {
    Map<Integer, Integer> currentLongest = new HashMap<>();

    public int findLongestChain(int[][] pairs) {
        TreeMap<Integer, List<int[]>> numToPair = new TreeMap<>();
        int res = Integer.MIN_VALUE;

        for(int[] p : pairs) {
            if(!numToPair.containsKey(p[0])) {
                numToPair.put(p[0], new ArrayList<>());
            }

            numToPair.get(p[0]).add(p);
        }

        Set<Integer> keySet = numToPair.keySet();
        Integer[] keyArray = keySet.toArray(new Integer[keySet.size()]);
        currentLongest.put(keyArray[keyArray.length - 1], 1);

        for(int i = keyArray.length - 1; i >= 0; i--) {
            List<int[]> ps = numToPair.get(keyArray[i]);

            if(ps != null) {
                for(int[] p : ps) {
                    res = Math.max(res, 1+ helper(p[1], keyArray, numToPair));
                }
            }

        }

        return res;
    }

    private int helper(int start, Integer[] keyArray, TreeMap<Integer, List<int[]>> numToPair) {
        if(start >= keyArray[keyArray.length - 1]) return 0;

        int res = Integer.MIN_VALUE;
        for(int i = 0; i < keyArray.length; i++) {
            if(keyArray[i] > start) {
                if(currentLongest.containsKey(keyArray[i])) {
                    res = Math.max(res, currentLongest.get(keyArray[i]));
                    continue;
                }

                List<int[]> ps = numToPair.get(keyArray[i]);

                int t = Integer.MIN_VALUE;
                for(int[] p : ps) {
                    t = Math.max(t, 1 + helper(p[1], keyArray, numToPair));
                }

                currentLongest.put(keyArray[i], t);
                res = Math.max(t, res);
            }


        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findLongestChain(new int[][]{{1,2},{2,3},{3,4}}));
    }
}
