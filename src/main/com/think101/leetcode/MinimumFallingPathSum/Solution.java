package main.com.think101.leetcode.MinimumFallingPathSum;

import java.util.List;

public class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size(), col = triangle.get(triangle.size()-1).size();
        int[][] dp = new int[row][col];

        for(int i=0; i<col; i++) {
            dp[row-1][i] = triangle.get(row-1).get(i);
        }

        // bottom up, each row
        for(int i=row-2; i>=0; i--) {
            for(int j=0; j<=i; j++) {
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]);
            }
        }

        return dp[0][0];
    }

}
