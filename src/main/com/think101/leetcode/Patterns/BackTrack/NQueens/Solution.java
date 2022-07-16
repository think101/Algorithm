package main.com.think101.leetcode.Patterns.BackTrack.NQueens;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> pDiags = new HashSet<>();
        Set<Integer> nDiags = new HashSet<>();
        List<List<String>> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();

        backtrack(n, 0, cols, pDiags, nDiags, res, curr);
        return res;
    }

    private void backtrack(int n, int i, Set<Integer> cols, Set<Integer> pDiags,
                           Set<Integer> nDiags, List<List<String>> res, List<String> curr) {
        System.out.println(i);

        if( i == n) {
            res.add(curr);
            return;
        }

        for(int j = 0; j < n; j++) {
            if(cols.contains(j) || pDiags.contains(i+j) || nDiags.contains(i-j)){
                continue;
            }

            StringBuilder sb = new StringBuilder();
            for(int k = 0; k < n; k++){
                if(k == j)
                    sb.append("Q");
                else
                    sb.append(".");
            }

            curr.add(sb.toString());
            cols.add(j);
            pDiags.add(i+j);
            nDiags.add(i-j);

            backtrack(n, i+1, cols, pDiags, nDiags, res, curr);

            curr.remove(curr.size() - 1);
            cols.remove(j);
            pDiags.remove(i+j);
            nDiags.remove(i-j);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solveNQueens(4));
    }
}
