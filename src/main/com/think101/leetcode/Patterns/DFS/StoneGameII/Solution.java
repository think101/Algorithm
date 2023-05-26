package main.com.think101.leetcode.Patterns.DFS.StoneGameII;

public class Solution {
    private int res = 0;

    public int stoneGameII(int[] piles) {
        dfs(piles, 0, 1, true, 0);
        dfs(piles, 0, 2, true, 0);

        return res;
    }

    private void dfs(int[] piles, int ind, int pileCnt, boolean isAlice, int sum) {
        if(ind >= piles.length) {
            res = Math.max(res, sum);
            return;
        }

        if(isAlice) {
            int i = 0;
            while(ind + i < piles.length && i < pileCnt) {
                sum += piles[ind + i];
                i++;
            }
        }

        for(int i = 1; i <= pileCnt * 2; i++) {
            dfs(piles, ind + pileCnt, i, !isAlice, sum);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] piles = {2, 7, 9, 4, 4};
        System.out.println(s.stoneGameII(piles));
    }
}
