package main.com.think101.leetcode.Patterns.ArraysHashing.NonDecreasingArray;

import java.util.Arrays;

public class Solution {
    public boolean checkPossibility(int[] nums) {

        return forward(Arrays.copyOf(nums, nums.length)) || backward(nums);
    }

    private boolean forward(int[] nums) {
        int count = 1;

        for(int i = 0; i < nums.length; i++) {
            if(i - 1 >= 0 && nums[i - 1] > nums[i]) {
                if(count == 0) return false;
                nums[i] = nums[i - 1];
                count--;
            }
        }

        return true;
    }

    private boolean backward(int[] nums) {
        int count = 1;

        for(int i = 0; i < nums.length; i++) {
            if(i - 1 >= 0 && nums[i - 1] > nums[i]) {
                if(count == 0) return false;
                nums[i - 1] = nums[i];
                count--;

                if(i - 2 >= 0 && nums[i - 2] > nums[i - 1]) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkPossibility(new int[]{4, 2, 3}));
        System.out.println(s.checkPossibility(new int[]{4, 2, 1}));
        System.out.println(s.checkPossibility(new int[]{3, 4, 2, 3}));
    }
}
