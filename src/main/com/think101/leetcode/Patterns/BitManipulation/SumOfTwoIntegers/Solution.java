package main.com.think101.leetcode.Patterns.BitManipulation.SumOfTwoIntegers;

public class Solution {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.getSum(1, 2));
        System.out.println(s.getSum(2, 3));
    }
}
