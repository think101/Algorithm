package main.com.think101.leetcode.Patterns.ArraysHashing.LongestCommonPrefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1) return strs[0];

        String res = findPrefix(strs[0], strs[1]);
        for(int i = 2; i < strs.length; i++) {
            res = findPrefix(res, strs[i]);
        }

        return res;
    }

    private String findPrefix(String s1, String s2) {
        if(s1.length() == 0 || s2.length() == 0) return "";

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s1.length() && i < s2.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) break;

            sb.append(s1.charAt(i));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(s.longestCommonPrefix(strs));
    }
}
