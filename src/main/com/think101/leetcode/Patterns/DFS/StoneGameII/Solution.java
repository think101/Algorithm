package main.com.think101.leetcode.Patterns.DFS.StoneGameII;

public class Solution {
    public int stoneGameII(int[] piles) {
        return dfs(piles, 0, 1, true);
    }

    private int dfs(int[] piles, int ind, int m, boolean isAlice) {
        if(ind >= piles.length) {
            return 0;
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

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] piles = {2, 7, 9};
        System.out.println(s.stoneGameII(piles));
    }
}
