package main.com.think101.leetcode.Patterns.DFS.StoneGameII;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    class MemoKey {
        private int[] piles;
        private int ind;
        private int m;
        private boolean isAlice;

        public MemoKey(int[] piles, int ind, int m, boolean isAlice) {
            this.piles = piles;
            this.ind = ind;
            this.m = m;
            this.isAlice = isAlice;
        }
    }

    private Map<MemoKey, Integer> memo = new HashMap<>();


    public int stoneGameII(int[] piles) {
        return dfs(piles, 0, 1, true);
    }

    private int dfs(int[] piles, int ind, int m, boolean isAlice) {
        if(ind >= piles.length) {
            return 0;
        }

        MemoKey key = new MemoKey(piles, ind, m, isAlice);
        if(memo.containsKey(key)) {
            System.out.println("found in memo");
            return memo.get(key);
        }

        int res = isAlice ? 0 : Integer.MAX_VALUE;
        int sum = 0;
        for(int j = 1; j <= m * 2; j++) {
            if(isAlice) {
                if(ind + j - 1 < piles.length) {
                    sum += piles[ind + j - 1];
                }
            }

            int r = dfs(piles, ind + j, Math.max(m, j), !isAlice);
            if(isAlice) res = Math.max(res, r + sum);
            else res = Math.min(res, r);
        }

        memo.put(key, res);

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] piles = {2, 7, 9};
        System.out.println(s.stoneGameII(piles));
    }
}
