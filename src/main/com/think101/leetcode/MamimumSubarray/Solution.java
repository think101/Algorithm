package main.com.think101.leetcode.MamimumSubarray;

public class Solution {

    /*
     * DP, based on V2
     */
    public int maxSubArrayV3(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int res = dp[0];
        for(int i=1; i<nums.length; i++){
            dp[i] = Math.max(nums[i], dp[i-1]+nums[i]);
            if(dp[i]>res)
                res = dp[i];
        }

        return res;

    }

    /*
     * dp[i] is the max sub array sum ends with index i
     *
     * recursion method, Time Limit Exceeded
     */
    public int maxSubArrayV2(int[] nums) {
        int[] dp = new int[nums.length];

        for(int i=0; i<nums.length; i++)
            dp[i] = dp(i, nums);

        int res = dp[0];
        for(int i=0; i<nums.length; i++)
            if(dp[i]>res)
                res = dp[i];

        return res;

    }

    private int dp(int i, int[] nums) {
        if(i==0) return nums[i];
        return Math.max(nums[i]+dp(i-1, nums), nums[i]);
    }

    public int maxSubArrayV1(int[] nums) {
        int sum = nums[0];
        int prevSum = nums[0];

        for(int i=1; i<nums.length; i++) {
            if(prevSum > 0 && prevSum+nums[i] > sum) {
                sum = prevSum+nums[i];
            }
            else if (prevSum <= 0 && nums[i] > sum)
                sum = nums[i];

            if(prevSum <=0)
                prevSum = nums[i];
            else
                prevSum += nums[i];
        }

        return sum;
    }
}