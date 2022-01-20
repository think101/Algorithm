package main.com.think101.leetcode.LongestIncreasingSubsequence;

public class Solution {

    public int lengthOfLIS(int[] nums) {
        // dp[i] the length of the longest increasing subsequence end at i;
        int[] dp = new int[nums.length];
        dp[0] = 1;

        for(int i=1; i<nums.length; i++) {
            int t = 1;
            dp[i] = 1;  // need to initialize each i
            for(int j=0; j<i; j++) {
                if(nums[i] > nums[j] && dp[j]+1 > t) {
                    t = dp[j]+1;
                    dp[i] = t;
                }
            }
        }

        int res = 1;
        for(int i=0; i<nums.length; i++) {
            if(dp[i] > res)
                res = dp[i];
        }

        return res;
    }
}