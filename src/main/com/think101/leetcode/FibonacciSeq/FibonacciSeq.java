package main.com.think101.leetcode.FibonacciSeq;

public class FibonacciSeq {
    public static void main(String[] args) {
        int n = 900;

        Solution solution = new Solution();
        System.out.println(solution.fib(n));
    }
}

class Solution {
    public int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;

        int[] fibs = new int[n+1];

        fibs[0] = 0;
        fibs[1] = 1;
        for(int i=2; i<=n; i++) {
            fibs[i] = fibs[i-1] + fibs[i-2];
        }

        return fibs[n];
    }

    public int fib2(int n) {
        if(n==0) return 0;
        if(n==1) return 1;

        int f0 = 0, f1 = 1;
        int t;

        for(int i=2; i<=n; i++) {
            t = f1;
            f1 = f0 + f1;
            f0 = t;
        }

        return f1;
    }
}

