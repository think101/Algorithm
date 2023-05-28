package main.com.think101.leetcode.Patterns.DFS.StoneGameII;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static class MemoKey {
        private final int[] piles;
        private final int ind;
        private final int m;
        private final boolean isAlice;

        public MemoKey(int[] piles, int ind, int m, boolean isAlice) {
            this.piles = piles;
            this.ind = ind;
            this.m = m;
            this.isAlice = isAlice;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            MemoKey other = (MemoKey) obj;

            return Arrays.equals(piles, other.piles) &&
                    ind == other.ind &&
                    m == other.m &&
                    isAlice == other.isAlice;
        }
    }

    private final Map<MemoKey, Integer> memo = new HashMap<>();


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
        int[] piles = {8270,7145,575,5156,5126,2905,8793,7817,5532,5726,7071,7730,5200,5369,5763,7148,8287,9449,7567,4850,1385,2135,1737,9511,8065,7063,8023,7729,7084,8407};
        System.out.println(s.stoneGameII(piles));
    }
}
