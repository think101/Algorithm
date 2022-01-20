package main.com.think101.leetcode.WiggleSubsequence;

public class Solution {

    public int wiggleMaxLength(int[] nums) {
        int len = nums.length;
        if(len == 1)
            return len;

        // dp[i]: max wiggle sequence length end with char at i
        int[] dp = new int[len];
        int[] positive = new int[len];

        dp[0] = 1;
        positive[0] = 1;
        positive[1] = nums[1]-nums[0];
        dp[1] = positive[1] != 0 ? 2 : 1;

        for(int i=2; i<len; i++) {
            int m = 1;
            dp[i] = 1;
            for(int j=0; j<i; j++) {
                int diff = nums[i]-nums[j];
                if(diff != 0 && diff * positive[j] <= 0 && dp[j]+1 > m) {
                    m = dp[j]+1;
                    dp[i] = m;
                    positive[i] = nums[i]-nums[j];
                }
            }
        }

        int res = 1;
        for(int i=0; i<len; i++)
            if(dp[i] > res)
                res = dp[i];

        return res;
    }
}

// not easy to figure out the edge cases