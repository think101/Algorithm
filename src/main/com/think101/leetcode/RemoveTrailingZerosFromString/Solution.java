package main.com.think101.leetcode.RemoveTrailingZerosFromString;

public class Solution {
    public String removeTrailingZeros(String num) {
        num = num.replaceAll("0+$", "");
        return num;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeTrailingZeros("123000"));
    }
}
