package main.com.think101.leetcode.Patterns.DP.LongestPalindromicSubstring;

public class SolutionDP {

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";

        int n = s.length();

        // dp[i][j] = true if s[i...j] is a palindrome
        boolean[][] dp = new boolean[n][n];
        String res = "";

        // first calculate diagonal, then calculate upper diagonal and so on
        // if j - i < 3, then s[i...j] is a palindrome if s[i] == s[j]
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
        System.out.println(s.longestPalindrome("cbbd"));
        System.out.println(s.longestPalindrome("a"));
    }
}
