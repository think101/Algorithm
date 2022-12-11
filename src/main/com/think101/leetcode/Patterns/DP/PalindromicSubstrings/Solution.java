package main.com.think101.leetcode.Patterns.DP.PalindromicSubstrings;

public class Solution {
    public int countSubstrings(String s) {
        int res = 0;

        for(int i = 0; i < s.length(); i++) {
            res += helper(s, i, i);
            res += helper(s, i, i+1);
        }

        return res;
    }

    private int helper(String s, int l, int r) {
        int res = 0;

        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            res++;
            l--;
            r++;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countSubstrings("aaa"));
    }
}