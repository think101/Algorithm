package main.com.think101.leetcode.TrappingRainWater;

public class Solution {

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};

        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        int[] prevMax = new int[height.length];
        int[] nextMax = new int[height.length];
        prevMax[0] = height[0];
        nextMax[height.length-1] = height[height.length-1];

        for(int i=1; i<height.length; i++) {
            prevMax[i] = Math.max(height[i], prevMax[i - 1]);
        }

        for(int i=height.length-2; i>=0; i--) {
            nextMax[i] = Math.max(height[i], nextMax[i + 1]);
        }

        int res = 0;
        for(int i=0; i<height.length; i++) {
            int t = Math.min(prevMax[i], nextMax[i]);
            res += t > height[i] ? t - height[i] : 0;
        }

        return res;
    }

    /*
     *  find the index >= previous max height
     *
     * it's possible there is never index has height >= previous max height, but still have index whose height
     *  lower than its neighbors, for example the last index which can hold water in example 1
     */
    public static int trap_wrong(int[] height) {
        int prevMaxIndex = 0;

        int res = 0;
        for(int i=1; i<height.length; i++) {
            if(height[i] >= height[prevMaxIndex]) {
                int t = Math.min(height[prevMaxIndex], height[i]);
                for(int j=prevMaxIndex+1; j<i; j++) {
                    res += t - height[j];
                }
                prevMaxIndex = i;
            }
        }

        return res;
    }

}
