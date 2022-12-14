package main.com.think101.leetcode.Patterns.DP.LongestIncreasingSubsequence;

import java.util.Stack;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        Stack<Integer> s = new Stack<>();
        int res = 0;

        for (int num : nums) {
            while (s.size() > 0 && s.peek() >= num) {
                s.pop();
            }

            s.push(num);
            res = Math.max(res, s.size());
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
