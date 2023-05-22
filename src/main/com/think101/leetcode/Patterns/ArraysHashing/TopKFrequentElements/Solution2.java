package main.com.think101.leetcode.Patterns.ArraysHashing.TopKFrequentElements;

import java.util.*;

public class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for(int n : nums) {
            cntMap.put(n, cntMap.getOrDefault(n, 0) + 1);
        }

        TreeMap<Integer, List<Integer>> cntToNums = new TreeMap<>(Collections.reverseOrder());
        for(int n : cntMap.keySet()) {
            int cnt = cntMap.get(n);

            if(!cntToNums.containsKey(cnt)) {
                cntToNums.put(cnt, new ArrayList<>());
            }

            cntToNums.get(cnt).add(n);
        }

        int[] res = new int[k];
        int t = 0;
        for(int key : cntToNums.keySet()) {
            for(int j : cntToNums.get(key)) {
                res[t++] = j;
            }

            if(t == k) break;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(Arrays.toString(s.topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
        System.out.println(Arrays.toString(s.topKFrequent(new int[]{1}, 1)));
    }
}
