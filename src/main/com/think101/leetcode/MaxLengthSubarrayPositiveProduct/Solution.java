package main.com.think101.leetcode.MaxLengthSubarrayPositiveProduct;

public class Solution {

    public int getMaxLen(int[] nums) {
        int[] dpPositive = new int[nums.length];
        int[] dpNegative = new int[nums.length];

        if(nums[0] == 0) {
            dpPositive[0] = dpNegative[0] = 0;
        }
        else if(nums[0] > 0) {
            dpPositive[0] = 1;
            dpNegative[0] = 0;
        }
        else {
            dpPositive[0] = 0;
            dpNegative[0] = 1;
        }

        int res = dpPositive[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == 0) {
                dpPositive[i] = dpNegative[i] = 0;
            }
            else if(nums[i] > 0) {
                if(nums[i-1] == 0) {
                    dpPositive[i] = 1;
                    dpNegative[i] = 0;
                }
                else {
                    dpPositive[i] = dpPositive[i-1] > 0 ? dpPositive[i-1] + 1 : 1;
                    dpNegative[i] = dpNegative[i-1] > 0 ? dpNegative[i-1] + 1 : 0;
                }
            }
            else {
                if(nums[i-1] == 0) {
                    dpPositive[i] = 0;
                    dpNegative[i] = 1;
                }
                else {
                    dpPositive[i] = dpNegative[i-1] > 0 ? dpNegative[i-1] + 1 : 0;
                    dpNegative[i] = dpPositive[i-1] > 0 ? dpPositive[i-1] + 1 : 1;
                }
            }

            if(dpPositive[i] > res)
                res = dpPositive[i];
        }

        return res;
    }
}
