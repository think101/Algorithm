package main.com.think101.leetcode.Patterns.DP.LongestArithmeticSubsequenceOfGivenDiff;

import java.util.*;

public class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, List<Integer>> numToPos = new HashMap<>();
        numToPos.put(arr[0], Arrays.asList(0));

        int[] dp = new int[arr.length];
        dp[0] = 1;
        int res = 1;

        for(int i = 1; i < arr.length; i++){
            dp[i] = 1;
            int t = arr[i] - difference;
            if(numToPos.containsKey(t)) {
                for(int j : numToPos.get(t)) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            if(!numToPos.containsKey(arr[i])) numToPos.put(arr[i], new ArrayList<>());
            numToPos.get(arr[i]).add(i);

            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestSubsequence(new int[]{1,5,7,8,5,3,4,2,1}, -2));
    }
}
