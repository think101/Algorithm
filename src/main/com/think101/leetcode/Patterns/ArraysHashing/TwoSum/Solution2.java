package main.com.think101.leetcode.Patterns.ArraysHashing.TwoSum;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(numToIndex.containsKey(target - nums[i]))
                return new int[]{numToIndex.get(target - nums[i]), i};

            numToIndex.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] res = s.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(res[0] + " " + res[1]);
    }
}
