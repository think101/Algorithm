package main.com.think101.leetcode.Patterns.BitManipulation.ReverseBits;

public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0;

        for(int i = 0; i < 32; i++) {
            res = res << 1;
            res = res | (n & 1);
            n = n >>> 1;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverseBits(43261596));
    }
}

