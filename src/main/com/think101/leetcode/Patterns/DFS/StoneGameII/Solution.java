package main.com.think101.leetcode.Patterns.DFS.StoneGameII;

public class Solution {
    public int stoneGameII(int[] piles) {
        return Math.max(dfs(piles, 0, 1, true, 0), dfs(piles, 0, 2, true, 0));
    }

    private int dfs(int[] piles, int ind, int pileCnt, boolean isAlice, int sum) {
        if(ind >= piles.length) {
            return sum;
        }

        if(isAlice) {
            int i = 0;
            while(ind + i < piles.length && i < pileCnt) {
                sum += piles[ind + i];
                i++;
            }
        }

        int res = isAlice ? 0 : Integer.MAX_VALUE;
        for(int j = 1; j <= pileCnt * 2; j++) {
            int r = dfs(piles, ind + pileCnt, j, !isAlice, sum);
            if(isAlice) res = Math.max(res, r);
            else res = Math.min(res, r);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] piles = {2, 7, 9, 4, 4};
        System.out.println(s.stoneGameII(piles));
    }
}
