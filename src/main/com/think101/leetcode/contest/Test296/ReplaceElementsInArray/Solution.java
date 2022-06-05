package main.com.think101.leetcode.contest.Test296.ReplaceElementsInArray;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        Map<Integer, Integer> numToIndex = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            numToIndex.put(nums[i], i);
        }

        for (int[] opt : operations) {
            int ind = numToIndex.get(opt[0]);
            nums[ind] = opt[1];
            numToIndex.put(opt[1], ind);
            numToIndex.remove(opt[0]);
        }

        return nums;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 4, 6};
        int[][] operations = {{1, 3}, {4, 7}, {6, 1}};
        System.out.println(Arrays.toString(s.arrayChange(nums, operations)));
    }
}