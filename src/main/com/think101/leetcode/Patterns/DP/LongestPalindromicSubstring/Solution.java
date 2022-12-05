package main.com.think101.leetcode.Patterns.DP.LongestPalindromicSubstring;

public class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        for(int i = 0; i < s.length(); i++) {
            int l = i;
            int r = i;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            l = l + 1;
            r = r - 1;

            if(r - l + 1 > res.length()) {
                res = s.substring(l, r+1);
            }

            l = i;
            r = i + 1;

            while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            l = l + 1;
            r = r - 1;

            if(r - l + 1 > res.length()) {
                res = s.substring(l, r+1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestPalindrome("babad"));
    }
}
