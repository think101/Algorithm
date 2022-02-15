package main.com.think101.leetcode.LongestConsecutiveSequence;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> keyLength = new HashMap<>();

        int result = 0;
        for(int i=0; i<nums.length; i++) {
            if(keyLength.containsKey(nums[i]))
                continue;

            int left = keyLength.get(nums[i]-1) == null ? 0 : keyLength.get(nums[i]-1);
            int right = keyLength.get(nums[i]+1) == null ? 0 : keyLength.get(nums[i]+1);
            int len = left + 1 + right;
            for(int k=nums[i]-left; k<=nums[i]+right; k++ ) {
                keyLength.put(k, len);
            }

            if(len > result)
                result = len;
        }

        return result;
    }
}
