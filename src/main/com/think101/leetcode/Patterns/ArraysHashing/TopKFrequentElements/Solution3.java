package main.com.think101.leetcode.Patterns.ArraysHashing.TopKFrequentElements;

import java.util.*;

public class Solution3 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> cnts = new HashMap<>();
        Map<Integer, List<Integer>> cntToNums = new TreeMap<>(Collections.reverseOrder());
        List<Integer> res = new ArrayList<>();

        for(int n : nums) {
            if(!cnts.containsKey(n)) cnts.put(n, 0);

            cnts.put(n, cnts.get(n) + 1);
        }

        for(int key : cnts.keySet()) {
            if(!cntToNums.containsKey(cnts.get(key))) cntToNums.put(cnts.get(key), new ArrayList<>());

            cntToNums.get(cnts.get(key)).add(key);
        }

        for(Map.Entry<Integer, List<Integer>> entry :cntToNums.entrySet()) {
            List<Integer> value = entry.getValue();
            res.addAll(value);

            if(res.size() == k) return res.stream().mapToInt(Integer::intValue).toArray();
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(Arrays.toString(s.topKFrequent(new int[]{1,1,1,2,2,3}, 2)));
        System.out.println(Arrays.toString(s.topKFrequent(new int[]{1}, 1)));
    }
}
