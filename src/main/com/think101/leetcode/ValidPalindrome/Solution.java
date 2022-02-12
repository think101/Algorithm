package main.com.think101.leetcode.ValidPalindrome;

public class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        if(s.isEmpty())
            return true;

        int l=0, r=s.length()-1;
        while(l<r) {
            if(s.charAt(l) != s.charAt(r))
                return false;

            l++;
            r--;
        }

        return true;
    }
}
