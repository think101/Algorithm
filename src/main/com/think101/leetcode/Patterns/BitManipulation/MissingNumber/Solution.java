package main.com.think101.leetcode.Patterns.BitManipulation.MissingNumber;

public class Solution {
    public int missingNumber(int[] nums) {
        int res = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            res = res ^ i;
            res = res ^ nums[i];
        }

        res = res ^ n;
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.missingNumber(new int[]{3,0,1}));
        System.out.println(s.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
    }
}
