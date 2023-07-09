package main.com.think101.leetcode.Patterns.TwoPointers.MinimumSizeSubarraySum;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0, sum = nums[0];
        int res = Integer.MAX_VALUE;

        while(true) {
            if(sum >= target) res = Math.min(res, r - l + 1);
            if(r >= nums.length - 1) break;

            while((sum <= target || l == r) && r < nums.length - 1) {
                sum += nums[++r];
                if(sum >= target) res = Math.min(res, r - l + 1);
            }

            while(sum >= target && l < r) {
                sum -= nums[l++];
                if(sum >= target) res = Math.min(res, r - l + 1);
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {10, 2, 3 };
        System.out.println(s.minSubArrayLen(6, nums));
    }
}
