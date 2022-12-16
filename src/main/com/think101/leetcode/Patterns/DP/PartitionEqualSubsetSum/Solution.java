package main.com.think101.leetcode.Patterns.DP.PartitionEqualSubsetSum;

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if(sum % 2 != 0) return false;

        return bt(nums, sum / 2, 0);
    }

    private boolean bt(int[] nums, int target, int i) {
        if(target == 0) return true;
        if(i >= nums.length) return false;

        return bt(nums, target - nums[i], i+1) || bt(nums, target, i+1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canPartition(new int[]{1,5,11,5}));
    }
}
