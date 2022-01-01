package main.com.think101.leetcode.DeleteAndEarn;

import java.util.Arrays;

public class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] earns = new int[10001];
        int[] result = new int[10001];

        for(int i : nums)
            earns[i] += i;

        result[0] = 0;
        result[1] = earns[1];

        for(int i=2; i<10001; i++) {
            result[i] = Math.max(result[i-1], result[i-2]+earns[i]);
        }

        return result[10000];
    }
}
