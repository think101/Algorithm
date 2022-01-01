package main.com.think101.leetcode.HouseRobber2;

public class Solution {

    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];

        int[][] dp = new int[nums.length][nums.length];
        for(int i=0; i<nums.length; i++)
            dp[i][i] = nums[i];

        for(int i=0; i<nums.length; i++) {
            for(int j=i+1; j<nums.length; j++) {
                if(j-2>=i)
                    dp[i][j] = Math.max(dp[i][j-1], dp[i][j-2]+nums[j]);
                else
                    dp[i][j] = Math.max(dp[i][j-1], nums[j]);
            }
        }

        return Math.max(dp[0][nums.length-2], dp[1][nums.length-1]);
    }
}
