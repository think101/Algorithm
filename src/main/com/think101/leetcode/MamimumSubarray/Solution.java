package main.com.think101.leetcode.MamimumSubarray;

public class Solution {
    public int maxSubArray(int[] nums) {
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