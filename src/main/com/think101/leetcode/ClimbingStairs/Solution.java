package main.com.think101.leetcode.ClimbingStairs;

public class Solution {
    public static void main(String[] args) {
        System.out.println(climbStairs(40));
    }

    public static int climbStairs(int n) {
        if(n<=2) return n;

        int f0 = 1, f1 = 2;
        int t;
        for(int i=3; i<=n; i++) {
            t = f1;
            f1 = f1 + f0;
            f0 = t;
        }

        return f1;
    }
}
