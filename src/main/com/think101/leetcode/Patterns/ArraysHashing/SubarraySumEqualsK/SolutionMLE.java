package main.com.think101.leetcode.Patterns.ArraysHashing.SubarraySumEqualsK;

public class SolutionMLE {
    public int subarraySum(int[] nums, int k) {
        int len = nums.length;
        int[][] dp = new int[len][len];
        int res = 0;

        for(int i = 0 ; i < len; i++) {
            for(int j = i; j < len; j++) {
                if(i == j) dp[i][j] = nums[i];
                else if(i == 0) dp[i][j] = dp[i][j - 1] + nums[j];
                else dp[i][j] = dp[i - 1][j] - nums[i - 1];

                if(dp[i][j] == k) res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SolutionMLE s = new SolutionMLE();
        int[] nums = {1, 1, 1};
        System.out.println(s.subarraySum(nums, 2));
    }
}
