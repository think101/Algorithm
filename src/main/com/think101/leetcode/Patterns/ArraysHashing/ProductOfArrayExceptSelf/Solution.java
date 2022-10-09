package main.com.think101.leetcode.Patterns.ArraysHashing.ProductOfArrayExceptSelf;

import java.util.Arrays;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        int[] res = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            left[i] = i - 1 >= 0 ? left[i-1] * nums[i] : nums[i];
            right[nums.length - 1 - i] = nums.length - i < nums.length
                    ? right[nums.length - i] * nums[nums.length - 1 - i]
                    : nums[nums.length - 1 - i];
        }

        for(int i = 0; i < nums.length; i++) {
            int t = 1;
            if(i - 1 >= 0)
                t = t * left[i-1];
            if(i + 1 < nums.length)
                t = t * right[i+1];

            res[i] = t;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.productExceptSelf(new int[]{1,2,3,4})));
    }
}
