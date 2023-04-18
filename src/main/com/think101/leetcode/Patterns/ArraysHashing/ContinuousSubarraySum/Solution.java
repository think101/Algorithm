package main.com.think101.leetcode.Patterns.ArraysHashing.ContinuousSubarraySum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> modIndex = new HashMap<>();
        modIndex.put(0, -1);

        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sum %= k;

            if(modIndex.containsKey(sum)) {
                if(i - modIndex.get(sum) > 1) return true;
            }
            else {
                modIndex.put(sum, i);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {23, 2, 4, 6, 7};
        System.out.println(s.checkSubarraySum(nums, 6));
    }
}
