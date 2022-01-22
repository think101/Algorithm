package main.com.think101.leetcode.CoinChange2;

public class Solution {

    public static void main(String[] args) {
        int[] coins = new int[]{1,2,5};
        int amount = 5;

        System.out.println(change(amount, coins));
    }

    public static int change(int amount, int[] coins) {
        int row = coins.length, col = amount+1;
        int[][] dp = new int[row][col];

        // column of amount 1, initialize as 1
        for(int i=0; i<row; i++)
            dp[i][0] = 1;

        for(int i=0; i<row; i++) {
            for(int j=1; j<col; j++) {
                dp[i][j] += i-1>=0 ? dp[i-1][j] : 0;
                dp[i][j] += j-coins[i]>=0 ? dp[i][j-coins[i]] : 0;
            }
        }

        //System.out.println(Arrays.deepToString(dp));

        return dp[row-1][col-1];
    }

    public static int change_WRONG(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 0;

        for(int i=1; i<= amount; i++) {
            for(int coin : coins) {
                if(i-coin == 0) {
                    dp[i] += 1;
                }
                else if (i-coin > 0) {
                    dp[i] += dp[i-coin];
                }
            }
        }

        return dp[amount];

    }
}


/*
       0 1 2 3 4 5
     1 1 1 1 1 1 1
     2 1 1 2 2 3 3
     5 1 1 2 2 3 4
 */