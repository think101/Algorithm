package main.com.think101.leetcode.Patterns.TwoPointers.TwoSumII;

import java.util.Arrays;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;

        while(true) {
            int t = numbers[l] + numbers[r];
            if( t == target)
                return new int[]{l+1, r+1};
            else if (t < target)
                l++;
            else
                r--;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.twoSum(new int[]{2,7,11,15}, 9)));
    }
}