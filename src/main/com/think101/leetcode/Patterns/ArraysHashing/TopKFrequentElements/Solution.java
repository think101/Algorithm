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

        List<Set<Integer>> buckets = new ArrayList<>(nums.length + 1);
        for(int i = 0; i < nums.length+1; i++) buckets.add(new HashSet<>());
        for(int key : cnts.keySet()) {
            buckets.get(cnts.get(key)).add(key);
        }

        int[] res = new int[k];
        int t = 0;
        for(int i = nums.length; i >= 0; i--) {
            for(int n : buckets.get(i)){
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