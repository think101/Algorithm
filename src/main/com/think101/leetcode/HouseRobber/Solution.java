package main.com.think101.leetcode.HouseRobber;

public class Solution {

    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0], nums[1]);

        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++) {
            result[i] = Math.max(result[i-2]+nums[i], result[i-1]);
        }

        return result[nums.length-1];
    }

    public int rob_v1(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0], nums[1]);

        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = nums[1];

        for(int i=2; i<nums.length; i++) {
            int t = nums[i];
            for(int j=i-2; j>=0; j--) {
                if(result[j]+nums[i] > t)
                    t = result[j]+nums[i];
            }

            if(result[i-1] > t)
                t = result[i-1];

            result[i] = t;
        }

        return result[nums.length-1];
    }

    /*
     * Add numbers at even indexes and odd indexes not correct
     */
    public int rob_wrong(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0], nums[1]);

        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = nums[1];

        for(int i=2; i<nums.length; i++) {
            result[i] = nums[i] + result[i-2];
        }

        return Math.max(result[result.length-1], result[result.length-2]);
    }
}
