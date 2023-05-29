package main.com.think101.leetcode.Patterns.DFS.StoneGameII;

public class Solution {
    public int stoneGameII(int[] piles) {
        int[][][] dp = new int[2][piles.length + 1][piles.length + 1];
        for (int p = 0; p < 2; p++) {
            for (int i = 0; i <= piles.length; i++) {
                for (int m = 0; m <= piles.length; m++) {
                    dp[p][i][m] = -1;
                }
            }
        }
        return dfs(dp, piles, 0, 1, 1);
    }

    private int dfs(int[][][] dp, int[] piles, int ind, int m, int isAlice
    ) {
        if(ind >= piles.length) {
            return 0;
        }

        if(dp[isAlice][ind][m] != -1) return dp[isAlice][ind][m];

        int res = isAlice == 1 ? 0 : Integer.MAX_VALUE;
        int sum = 0;
        for(int j = 1; j <= m * 2; j++) {
            if(ind + j - 1 >= piles.length) break;

            if(isAlice == 1) {
                if(ind + j - 1 < piles.length) {
                    sum += piles[ind + j - 1];
                }
            }

            int r = dfs(dp, piles, ind + j, Math.max(m, j), isAlice == 1 ? 0 : 1);
            if(isAlice == 1) res = Math.max(res, r + sum);
            else res = Math.min(res, r);
        }

        dp[isAlice][ind][m] = res;

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] piles = {8270,7145,575,5156,5126,2905,8793,7817,5532,5726,7071,7730,5200,5369,5763,7148,8287,9449,7567,4850,1385,2135,1737,9511,8065,7063,8023,7729,7084,8407};
        System.out.println(s.stoneGameII(piles));
    }
}
