package main.com.think101.leetcode.Patterns.TwoPointers.ValidPalindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        int l = 0, r = s.length() > 0 ? s.length() - 1 : 0;

        while(l < r) {
            if(l == s.length() || r < 0) break;

            if(s.charAt(l++) != s.charAt(r--))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
    }
}