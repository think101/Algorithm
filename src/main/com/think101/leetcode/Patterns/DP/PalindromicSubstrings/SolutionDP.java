package main.com.think101.leetcode.Patterns.DP.PalindromicSubstrings;

public class SolutionDP {
    public int countSubstrings(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        int res = 0;
        for(int i = 0; i < len; i++) {
            dp[i][i] = 1;
            res++;
        }

        for(int i = 1; i < len; i++) {
            for(int j = 0; j < len; j++) {
                // dp[j][j + i]
                if(j + i < len && s.charAt(j) == s.charAt(j + i) && ( dp[j + 1][j + i - 1] == 1 || i < 3)) {
                    dp[j][j + i] = 1;
                    res++;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        SolutionDP s = new SolutionDP();
        System.out.println(s.countSubstrings("aaa"));
    }
}
