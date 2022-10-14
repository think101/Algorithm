package main.com.think101.leetcode.Patterns.TwoPointers.TrappingRainWater;

public class Solution {
    public int trap(int[] height) {
        int len = height.length;
        int[] pMax = new int[len];
        int[] nMax = new int[len];
        int res = 0;

        nMax[len-1] = height[len-1];
        for(int i = len-2; i >= 0; i--){
            nMax[i] = Math.max(height[i+1], nMax[i+1]);
        }

        pMax[0] = height[0];
        for(int i = 1; i < len; i++) {
            pMax[i] = Math.max(height[i-1], pMax[i-1]);
        }

        for(int i = 0; i < len; i++){
            res += Math.min(pMax[i], nMax[i]) > height[i] ?
                    Math.min(pMax[i], nMax[i]) - height[i] :
                    0;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
