package main.com.think101.leetcode.MaximumProductSubarray;

public class Solution {

    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];

        int res = dpMax[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == 0) {
                dpMax[i] = dpMin[i] = 0;
            }
            else if(dpMax[i-1] == 0) {
                dpMax[i] = dpMin[i] = nums[i];
            }
            else {
                dpMax[i] = Math.max(dpMax[i-1] * nums[i], Math.max(dpMin[i-1] * nums[i], nums[i]));
                dpMin[i] = Math.min(dpMax[i-1] * nums[i], Math.min(dpMin[i-1] * nums[i], nums[i]));
            }

            if(dpMax[i] > res)
                res = dpMax[i];
        }

        return res;
    }
}
