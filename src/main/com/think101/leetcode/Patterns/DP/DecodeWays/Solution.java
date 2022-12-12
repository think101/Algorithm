package main.com.think101.leetcode.Patterns.DP.DecodeWays;

public class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        int[] dp = new int[len];

        for(int i = 0; i < len; i++) {
            int cnt = 0;
            if(s.charAt(i) > '0' && s.charAt(i) <= '9') {
                cnt += i - 1 >= 0 ? dp[i - 1] : 1;
            }
            if(i - 1 >= 0 && s.charAt(i - 1) != '0') {
                int t = Integer.parseInt(s.substring(i-1, i+1));
                if(t >= 10 && t <= 26) {
                    cnt += i - 2 >= 0 ? dp[i - 2] : 1;
                }
            }

            dp[i] = cnt;
        }

        return dp[len - 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numDecodings("226"));
    }
}
