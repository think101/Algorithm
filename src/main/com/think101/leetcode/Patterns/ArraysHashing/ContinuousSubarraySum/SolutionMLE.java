package main.com.think101.leetcode.Patterns.ArraysHashing.ContinuousSubarraySum;

public class SolutionMLE {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;
        int[][] dp = new int[len][len];

        for(int i = 0 ; i < len; i++) {
            for(int j = i; j < len; j++) {
                if(i == j) dp[i][j] = nums[i];
                else if(i == 0) dp[i][j] = dp[i][j - 1] + nums[j];
                else dp[i][j] = dp[i - 1][j] - nums[i - 1];

                if(j - i >= 1 && dp[i][j] % k == 0) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        SolutionMLE s = new SolutionMLE();
        int[] nums = {23, 2, 4, 6, 7};
        System.out.println(s.checkSubarraySum(nums, 6));
    }
}
