package main.com.think101.leetcode.contest.ContainsDuplicateII;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, TreeSet<Integer>> numIndexes = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(!numIndexes.containsKey(nums[i])) {
                numIndexes.put(nums[i], new TreeSet<>());
            }

            Integer floor = numIndexes.get(nums[i]).floor(i);
            if(floor != null && Math.abs(floor - i) <= k)
                return true;

            Integer ceiling = numIndexes.get(nums[i]).ceiling(i);
            if(ceiling != null && Math.abs(ceiling - i) <= k)
                return true;

            numIndexes.get(nums[i]).add(i);
        }

        return false;
    }
}
