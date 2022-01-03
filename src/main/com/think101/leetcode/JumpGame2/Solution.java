package main.com.think101.leetcode.JumpGame2;

public class Solution {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,1,1};

        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        if(nums.length==1)
            return 0;

        if(nums[0] >= nums.length-1)
            return 1;

        int[] furthestIndex = new int[nums.length]; // furthest index for steps
        furthestIndex[0] = 0;
        furthestIndex[1] = nums[0];

        // for each step
        for(int i=2; i<nums.length; i++) {
            int t = furthestIndex[i-1];
            int furthest = 0;

            for(int j=furthestIndex[i-2]+1; j<=t; j++) {
                if(nums[j]+j >= nums.length-1)
                    return i;

                if(nums[j]+j > furthest)
                    furthest = nums[j]+j;
            }

            furthestIndex[i] = furthest;



        }

        return 0;
    }
}
