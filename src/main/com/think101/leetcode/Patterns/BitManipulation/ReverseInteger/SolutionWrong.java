package main.com.think101.leetcode.Patterns.BitManipulation.ReverseInteger;

public class SolutionWrong {
    public int reverse(int x) {
        int res = 0;

        while(x > 0) {
            res = res & x;
            x >>= 1;
            res <<= 1;
        }

        return res;
    }

    public static void main(String[] args) {
        SolutionWrong s = new SolutionWrong();
        System.out.println(s.reverse(123));
    }
}
