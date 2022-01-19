package main.com.think101.leetcode.LongestPalindromicSubsequence;

public class Solution {

    public static void main(String[] args) {
        System.out.println(longestPalindromeSubseq("bbbababb"));
    }

    public static int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        for(int i=0; i<len; i++) {
            for(int j=0; j<len; j++) {
                if(i==0) {
                    dp[j][j+i] = 1;
                }
                else if (i==1) {
                    if(j+i<len) {
                        if(s.charAt(j) == s.charAt(j+i)) {
                            dp[j][j+i] = 2;
                        }
                        else {
                            dp[j][j+i] = 1;
                        }
                    }
                }
                else {
                    if(j+i<len) {
                        if(s.charAt(j) == s.charAt(j+i)) {
                            dp[j][j+i] = dp[j+1][j+i-1]+2;
                        }
                        else {
                            dp[j][j+i] = Math.max(dp[j+1][j+i], dp[j][j+i-1]);
                        }
                    }
                }
            }
        }

//        for(int i=0; i<len; i++) {
//            for(int j=0; j<len; j++) {
//                if(j+i < len)
//                    System.out.print(dp[j][j+i] + " " );
//            }
//            System.out.println();
//        }

        return dp[0][len-1];
    }
}
