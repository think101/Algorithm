package main.com.think101.leetcode.Patterns.TwoPointers.ContainerWithMostWater;

public class Solution {
    int res = 0;

    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;

        while(l < r) {
            res = Math.max(res, (r - l) * Math.min(height[l], height[r]));
            if(height[l] <= height[r]) l++;
            else r--;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
