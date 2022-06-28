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
            for(int j = i; j < cnts.size(); j++) {
                if(cnts.get(cnts.keySet().toArray()[j]) < 1 + (i == j ? 1 : 0))
                    continue;

                int t = target - (int)cnts.keySet().toArray()[i] - (int)cnts.keySet().toArray()[j];

                Map.Entry<Integer, Integer> floorEntry =  cnts.floorEntry(t);
                int floor = floorEntry == null ? (int)cnts.keySet().toArray()[0] : floorEntry.getKey();
                if(cnts.get(floor) >= (1 + (floor == (int)cnts.keySet().toArray()[i] ? 1 : 0) +
                        (floor == (int)cnts.keySet().toArray()[j] ? 1 : 0))
                        && Math.abs(target - (int)cnts.keySet().toArray()[i] - (int)cnts.keySet().toArray()[j] - floor)
                        < Math.abs(target - result)) {
                    result = (int)cnts.keySet().toArray()[i] + (int)cnts.keySet().toArray()[j] + floor;
                }

                Map.Entry<Integer, Integer> ceilingEntry =  cnts.ceilingEntry(t);
                int ceiling = ceilingEntry == null ? (int)cnts.keySet().toArray()[cnts.size() - 1]
                        : ceilingEntry.getKey();
                if(cnts.get(ceiling) >= (1 + (ceiling == (int)cnts.keySet().toArray()[i] ? 1 : 0) +
                        (ceiling == (int)cnts.keySet().toArray()[j] ? 1 : 0))
                        && Math.abs(target - (int)cnts.keySet().toArray()[i] - (int)cnts.keySet().toArray()[j] - ceiling)
                        < Math.abs(target - result)) {
                    result = (int)cnts.keySet().toArray()[i] + (int)cnts.keySet().toArray()[j] + ceiling;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.threeSumClosest(new int[]{1, 1, -1, -1, 3}, -1));

    }
}