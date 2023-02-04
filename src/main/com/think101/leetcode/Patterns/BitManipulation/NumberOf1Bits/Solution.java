package main.com.think101.leetcode.Patterns.BitManipulation.NumberOf1Bits;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = n & 1;

        while (n != 0) {
            n = n >> 1;
            res += n & 1;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.hammingWeight(00000000000000000000000000001011));
        System.out.println(s.hammingWeight(00000000000000000000000010000000));
    }
}