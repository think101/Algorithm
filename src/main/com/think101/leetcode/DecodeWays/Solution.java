package main.com.think101.leetcode.DecodeWays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(numDecodings("227"));
    }

    public static int numDecodings(String s) {
        if(s.length() == 1) return s.charAt(0) == '0' ? 0 : 1;

        int[] dp = new int[s.length()];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;

        for(int i=1; i<s.length(); i++) {
            if(s.charAt(i-1) == '0' || s.charAt(i-1) > '2') {
                if(s.charAt(i) == '0') return 0;

                dp[i] = dp[i-1];
            }
            else {
                if(i-2>=0) {
                    if(s.charAt(i) == '0')
                        dp[i] = dp[i-2];
                    else if(s.charAt(i) > '6')
                        dp[i] = dp[i-1];
                    else
                        dp[i] = dp[i-2] + dp[i-1];
                }
                else {
                    if(s.charAt(i) == '0' || s.charAt(i) > '6')
                        dp[i] = dp[i-1];
                    else
                        dp[i] = dp[i-1] + 1;
                }
            }
        }

        return dp[s.length()-1];
    }
}
