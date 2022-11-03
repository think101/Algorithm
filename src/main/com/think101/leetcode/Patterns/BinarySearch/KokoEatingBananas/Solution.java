package main.com.think101.leetcode.Patterns.BinarySearch.KokoEatingBananas;

import java.util.Arrays;

public class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int len = piles.length;
        int res = Integer.MAX_VALUE;

        int l = 0, r = piles[len - 1];
        while(l <= r) {
            int m = (l + r) / 2;
            int t = 0;

            for (int pile : piles) {
                if (pile <= m) t++;
                else t += Math.ceil((double) pile / m);
            }

            if(t <= h) {
                res = Math.min(res, m);
                r = m - 1;
            }
            else {
                l = m + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }
}