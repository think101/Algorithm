package main.com.think101.leetcode.DominoAndTrominoTiling;

public class Solution {

    public static void main(String[] args) {
        System.out.println(numTilings(30));
    }

    public static int numTilings(int n) {
        long[][] dp = new long[n+1][3];
        dp[0][0] = 1;
        dp[1][0] = 1;

        for(int i=2; i<=n; i++) {
            dp[i][0] = (int) ((dp[i-1][0] + dp[i-2][0] + dp[i-1][1] + dp[i-1][2]) % (Math.pow(10, 9) + 7));
            dp[i][1] = (int) ((dp[i-2][0] + dp[i-1][2]) % (Math.pow(10, 9) + 7));
            dp[i][2] = (int) ((dp[i-2][0] + dp[i-1][1]) % (Math.pow(10, 9) + 7));
        }

        return (int) (dp[n][0] );
    }


}
