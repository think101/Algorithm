package main.com.think101.leetcode.Patterns.DP.HouseRobberII;

public class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }

    private int helper(int[] nums, int i, int j) {
        if(j - i + 1 == 1) return nums[i];

        int[] dp = new int[j - i + 1];
        dp[0] = nums[i];
        dp[1] = Math.max(nums[i], nums[i+1]);

        for(int a = 2; a < dp.length; a++) {
            dp[a] = Math.max(dp[a-2] + nums[a+i], dp[a-1]);
        }

        return dp[dp.length - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.rob(new int[]{2,3,2}));
    }
}