package main.com.think101.leetcode.TopKFrequentElements;

import java.util.*;

public class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int i : nums) {
            if(!freq.containsKey(i))
                freq.put(i, 0);

            freq.put(i, freq.get(i)+1);
        }

        Map<Integer, List<Integer>> freqToNum = new TreeMap<>(Collections.reverseOrder());
        for(Integer i : freq.keySet()) {
            if(!freqToNum.containsKey(freq.get(i))) {
                freqToNum.put(freq.get(i), new ArrayList<>());
            }

            freqToNum.get(freq.get(i)).add(i);
        }

        int index = 0;
        int[] result = new int[k];
        for(Map.Entry<Integer, List<Integer>> entry : freqToNum.entrySet()) {
            for(int i : entry.getValue()) {
                result[index++] = i;

                if(index == k)
                    return result;
            }
        }

        return result;

    }
}
