package main.com.think101.leetcode.Patterns.DP.LongestPalindromicSubstring;

public class SolutionDP {

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = "";

        for(int i = n - 1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i+1][j-1]);

                if(dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j+1);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SolutionDP s = new SolutionDP();
        System.out.println(s.longestPalindrome("babad"));
    }
}
