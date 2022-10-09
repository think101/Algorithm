package main.com.think101.leetcode.Patterns.ArraysHashing.TopKFrequentElements;

import java.util.*;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cnts = new HashMap<>();
        for(int i : nums){
            if(!cnts.containsKey(i))
                cnts.put(i, 0);

            cnts.put(i, cnts.get(i) + 1);
        }

        Map<Integer, Set<Integer>> cntToNums = new TreeMap<>(Collections.reverseOrder());
        for(int key : cnts.keySet()) {
            if(!cntToNums.containsKey(cnts.get(key)))
                cntToNums.put(cnts.get(key), new HashSet<>());

            cntToNums.get(cnts.get(key)).add(key);
        }

        int[] res = new int[k];
        int t = 0;
        for(int key : cntToNums.keySet()) {
            for(int n : cntToNums.get(key)){
                res[t++] = n;
                if (t == k)
                    return res;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
        System.out.println(Arrays.toString(s.topKFrequent(new int[]{1}, 1)));
    }
}