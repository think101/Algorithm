package main.com.think101.leetcode.Patterns.ArraysHashing.TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> s = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(s.containsKey(target - nums[i]))
                return new int[]{s.get(target - nums[i]), i};

            s.put(nums[i], i);
        }

        return null;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.twoSum(new int[]{2,7,11,15}, 9)));
        System.out.println(Arrays.toString(s.twoSum(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(s.twoSum(new int[]{3,3}, 6)));
    }
}
