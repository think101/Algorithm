package main.com.think101.leetcode.Patterns.BitManipulation.ReverseInteger;

/*
 * This actually not belongs to Bit Manipulation
 */

public class Solution {
    public int reverse(int x) {
        long res = 0;

        while(x != 0) {
            int r = x % 10;
            res = res * 10 + r;

            if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
                res = 0;
                break;
            }

            x = x / 10;
        }

        return (int)res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reverse(123));
        System.out.println(s.reverse(-123));
        System.out.println(s.reverse(120));
        System.out.println(s.reverse(1534236469));
    }
}
