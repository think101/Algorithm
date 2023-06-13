package main.com.think101.leetcode.Patterns.ArraysHashing.MaximumAverageSubarrayI;

public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;

        for(int i = 0; i < k; i++) sum += nums[i];

        double res = sum * 1.0 / k;

        for(int i = k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - k];

            res = Math.max(res, sum * 1.0 / k);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 12, -5, -6, 50, 3};
        System.out.println(s.findMaxAverage(nums, 4));
    }
}
