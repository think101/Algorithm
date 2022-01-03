package main.com.think101.leetcode.JumpGame;

public class Solution {

    /*
     * calculate the furthest reachable index for each index
     *
     */
    public boolean canJumpV1(int[] nums) {
        int[] furthestIndex = new int[nums.length];
        furthestIndex[0] = nums[0];

        for(int i=1; i<nums.length; i++) {
            if(nums[i-1]==0 && furthestIndex[i-1] < i) return false;
            furthestIndex[i] = Math.max(furthestIndex[i-1], nums[i] + i);
        }

        return true;
    }
}
