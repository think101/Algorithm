package main.com.think101.leetcode.Patterns.ArraysHashing.LengthOfLastWord;

public class Solution {
    public int lengthOfLastWord(String s) {
        String[] res = s.split("\\s+");

        return res[res.length - 1].length();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "Hello World";
        System.out.println(s.lengthOfLastWord(str));
    }
}
