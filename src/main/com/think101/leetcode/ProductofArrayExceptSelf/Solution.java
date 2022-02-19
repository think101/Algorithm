package main.com.think101.leetcode.ProductofArrayExceptSelf;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] forward = new int[nums.length];
        int[] backward = new int[nums.length];

        forward[0] = nums[0];
        for(int i=1; i<nums.length; i++)
            forward[i] = forward[i-1]*nums[i];

        backward[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2; i>=0; i--)
            backward[i] = backward[i+1] * nums[i];

        int result[] = new int[nums.length];
        result[0] = backward[1];
        result[nums.length-1] = forward[nums.length-2];
        for(int i=1; i<nums.length-1; i++)
            result[i] = forward[i-1] * backward[i+1];

        return result;
    }
}
