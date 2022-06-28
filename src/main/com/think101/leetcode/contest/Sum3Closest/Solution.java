package main.com.think101.leetcode.contest.Sum3Closest;

import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        TreeMap<Integer, Integer> cnts = new TreeMap<>();

        for(int i : nums) {
            if(!cnts.containsKey(i)) {
                cnts.put(i, 0);
            }

            cnts.put(i, cnts.get(i) + 1);
        }

        int result = Integer.MAX_VALUE;

        for(int i = 0; i < cnts.size(); i++) {
            for(int j = i+1; j < cnts.size(); j++) {
                int t = target - (int)cnts.keySet().toArray()[i] - (int)cnts.keySet().toArray()[j];

                Map.Entry<Integer, Integer> floorEntry =  cnts.floorEntry(t);
                int floor = floorEntry == null ? 0 : floorEntry.getKey();
                if(cnts.get(floor) >= (1 + (floor == i ? 1 : 0) + (floor == j ? 1 : 0))
                        && Math.abs(target - i - j - floor) < Math.abs(target - result)) {
                    result = i + j + floor;
                }

                Map.Entry<Integer, Integer> ceilingEntry =  cnts.ceilingEntry(t);
                int ceiling = ceilingEntry == null ? (int)cnts.keySet().toArray()[cnts.size() - 1]
                        : ceilingEntry.getKey();
                if(cnts.get(ceiling) >= (1 + (ceiling == i ? 1 : 0) + (ceiling == j ? 1 : 0))
                        && Math.abs(target - i - j - ceiling) < Math.abs(target - result)) {
                    result = i + j + ceiling;
                }
            }
        }

        return result;
    }
}