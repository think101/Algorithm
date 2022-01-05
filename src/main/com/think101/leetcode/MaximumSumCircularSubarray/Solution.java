package main.com.think101.leetcode.MaximumSumCircularSubarray;

public class Solution {

    public int maxSubarraySumCircular(int[] nums) {
        // if all negative, return max element
        int checkRes = checkAllNegative(nums);
        if( checkRes < 0)
            return checkRes;

        int[] minusNums = new int[nums.length];
        int sum=0;

        
        for(int i=0; i<nums.length; i++) {
            minusNums[i] = -1 * nums[i];
            sum += nums[i];
        }

        return Math.max(maxSubArray(nums), sum + maxSubArray(minusNums));

    }

    private int maxSubArray(int[] nums) {
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

    private int checkAllNegative(int[] nums) {
        int res = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num >= 0)
                return 1;

            if (num > res)
                res = num;
        }

        return res;
    }
}

// hint:
// case 1: same as Maximum Sum Subarray
// case 2: maximum sum subarray cross the array boundary, suffix + prefix, there must be elements between
//         max(prefix + suffix) = max(sum - mid) = sum + maxSubarray(-arr)