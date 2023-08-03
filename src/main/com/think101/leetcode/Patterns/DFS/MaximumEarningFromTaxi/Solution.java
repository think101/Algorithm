package main.com.think101.leetcode.Patterns.DFS.MaximumEarningFromTaxi;

import java.util.*;

class Solution {
    public long maxTaxiEarnings(int n, int[][] A) {
        Arrays.sort(A, (a, b) -> a[0] - b[0]);
        long[] dp = new long[n + 1];
        int j = 0;
        for(int i = 1; i <= n; ++i) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            while (j < A.length && A[j][0] == i) {
                dp[A[j][1]] = Math.max(dp[A[j][1]], dp[i] + A[j][1] - A[j][0] + A[j][2]);
                ++j;
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] rides = new int[][]{{1,6,1},{3,10,2},{10,12,3},{11,12,2},{12,15,2},{13,18,1}};
        System.out.println(s.maxTaxiEarnings(20, rides));
    }
}
