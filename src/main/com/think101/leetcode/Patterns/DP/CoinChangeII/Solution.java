package main.com.think101.leetcode.Patterns.DP.CoinChangeII;

public class Solution {
    public int change(int amount, int[] coins) {
        int row = coins.length;
        int[][] dp = new int[row][amount + 1];

        for(int i = 0; i < row; i++) dp[i][0] = 1;
        for(int i = 0; i < row; i++) {
            for(int j = 1; j <= amount; j++) {
                int t = i - 1 >= 0 ? dp[i - 1][j] : 0;
                if(j - coins[i] >= 0) t += dp[i][j - coins[i]];

                dp[i][j] = t;
            }
        }

        return dp[row - 1][amount];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.change(5, new int[]{1, 2, 5}));
    }
}