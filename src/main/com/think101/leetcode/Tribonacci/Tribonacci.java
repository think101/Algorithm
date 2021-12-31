package main.com.think101.leetcode.Tribonacci;

public class Tribonacci {
    public static void main(String[] args) {
        int n = 25;

        Solution solution = new Solution();
        System.out.println(solution.fib(n));
    }
}

class Solution {
    public int fib(int n) {
        if(n <= 1) return n;
        if(n==2) return 1;

        int t0 = 0, t1 = 1, t2 = 1;
        int t;

        for(int i=3; i<=n; i++) {
            t = t2;

            t2 = t2 + t1 + t0;
            t0 = t1;
            t1 = t;
        }

        return t2;
    }
}

