package main.com.think101.leetcode.IsSubsequence;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        if(s.length() == 1) return t.contains(s);

        int index = t.indexOf(s.charAt(0));
        if(index < 0)
            return false;
        else
            return isSubsequence(s.substring(1), t.substring(index+1));
    }
}
