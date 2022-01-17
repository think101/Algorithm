package main.com.think101.leetcode.LongestPalindromicSubstring;

public class Solution {

    /*
     * idea: loop through each char as the center of a palindrom substring, note the center of a palindrom can be a char
     * (for example "aba") or the place between two char (for example "abba")
     * return the max length substring got from above process
     */
    public String longestPalindrome(String s) {
        int len = s.length();

        int maxLen = 0;
        int maxIndex = -1;
        for(int i=0; i<len; i++) {
            int t = Math.max(maxLength(s, i, i), maxLength(s, i, i+1));
            if(t>maxLen) {
                maxLen = t;
                maxIndex = i;
            }
        }

        return s.substring(maxIndex-(maxLen-1)/2, maxIndex+(maxLen)/2+1);
    }

    private int maxLength(String s, int l, int r) {
        int len = 0;
        while(l>=0 && r<s.length()) {
            if(s.charAt(l) != s.charAt(r)) {
                break;
            }

            len = r-l+1;
            l--;
            r++;
        }
        return len;
    }
}
