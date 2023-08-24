package main.com.think101.leetcode.Patterns.Other.RepeatedSubstringPattern;

public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if(s.length() <= 1) return false;

        for(int j = s.length() - 1; j >= s.length() / 2; j--) {
            if(s.charAt(j) == s.charAt(0)) {
                int len = s.length() - j;

                if(len <= j && s.substring(0, len).equals(s.substring(j))
                        && repeated(s.substring(len, j), s.substring(j))) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean repeated(String s, String p) {
        if(s.length() == 0) return true;
        if(s.length() % p.length() != 0) return false;

        if(!s.substring(0, p.length()).equals(p)) return false;

        return repeated(s.substring(p.length()), p);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.repeatedSubstringPattern("abab"));
    }
}
