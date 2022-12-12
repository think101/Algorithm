package main.com.think101.leetcode.Patterns.DP.MaximumProductSubarray;

public class Solution {
    public int maxProduct(int[] nums) {
        int[] dp = new int[nums.length];
        int res = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
            dp[i] = i - 1 >= 0 ? Math.max(nums[i], dp[i-1] * nums[i]) : nums[i];
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxProduct(new int[]{2,3,-2,4}));
    }
}
