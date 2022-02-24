package main.com.think101.leetcode.IncreasingTripletSubsequence;

public class Solution {

    public boolean increasingTriplet(int[] nums) {
        int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;

        for(int n : nums) {
            if(n <= small) small = n;
            else if(n <= big) big = n;
            else return true;
        }

        return false;
    }
    
    public boolean increasingTriplet_TLE2(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;

        for(int i=1; i<nums.length; i++) {
            for(int j=0; j<i; j++) {
                dp[i] = nums[i] > nums[j] ? Math.max(dp[j]+1, dp[i]) : Math.max(1, dp[i]);
            }

            if(dp[i] >= 3)
                return true;
        }

        return false;
    }

    public boolean increasingTriplet_TLE1(int[] nums) {

        for(int i=0; i<nums.length; i++) {
            int jStart = i+1;
            while(true) {
                int j = findFirstBiggerThanTarget(nums, jStart, nums[i]);
                if(j == -1) {
                    break;
                }
                else {
                    jStart = j+1;

                    int k = findFirstBiggerThanTarget(nums, j+1, nums[j]);

                    if(k != -1)
                        return true;
                }
            }
        }

        return false;
    }

    // return index of  the 1st number bigger than target
    // if not found return -1;
    private int findFirstBiggerThanTarget(int[] nums, int start, int target) {
        for(int i=start; i<nums.length; i++)
            if(nums[i] > target)
                return i;

        return -1;
    }
}
