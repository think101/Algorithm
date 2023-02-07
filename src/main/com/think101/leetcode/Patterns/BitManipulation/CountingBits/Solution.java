package main.com.think101.leetcode.Patterns.BitManipulation.CountingBits;

public class Solution {
    public int[] countBits(int n) {
        if(n == 0) return new int[1];
        if(n == 1) return new int[]{0, 1};

        int[] res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        for(int i = 2; i <= n; i++) {
            if(i%2 == 0) res[i] = res[i/2];
            else res[i] = res[i-1] + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countBits(2));
        System.out.println(s.countBits(5));
    }
}
