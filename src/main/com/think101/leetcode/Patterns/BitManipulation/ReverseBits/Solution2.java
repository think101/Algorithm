package main.com.think101.leetcode.Patterns.BitManipulation.ReverseBits;

public class Solution2 {
    public int reverseBits(int n) {
        String s = Integer.toBinaryString(n);
        if(s.length() < 32) {
            s = new String(new char[32-s.length()]).replace("\0", "0") + s;
        }
        s = new StringBuilder(s).reverse().toString();

        return (int)Long.parseLong(s, 2);
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.reverseBits(43261596));
    }
}
