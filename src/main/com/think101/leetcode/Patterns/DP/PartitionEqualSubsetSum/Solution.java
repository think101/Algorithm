package main.com.think101.leetcode.Patterns.DP.PartitionEqualSubsetSum;

public class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0, max = 0;

        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }

        if(max * 2 > sum || sum % 2 != 0) return false;
        if(max * 2 == sum) return true;

        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for(int n : nums) {
            for(int i = sum; i >= 0; i-- ) {
                if(dp[i] == 1 && i + n <= sum) dp[i + n] = 1;
            }

            if(dp[sum / 2 ] == 1) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canPartition(new int[]{2, 2, 3, 5}));
    }
}
