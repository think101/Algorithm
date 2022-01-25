package main.com.think101.leetcode.ContainerWithMostWater;

public class Solution {

    public int maxArea(int[] height) {
        int l = 0, r = height.length-1;

        int ans = 0;
        while(l<r) {
            int t = Math.min(height[l], height[r]) * (r-l);
            if(t > ans)
                ans = t;

            if(height[l]<height[r])
                l++;
            else
                r--;
        }

        return ans;
    }
}
