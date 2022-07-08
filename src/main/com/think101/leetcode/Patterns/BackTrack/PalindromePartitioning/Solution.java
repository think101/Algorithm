package main.com.think101.leetcode.Patterns.BackTrack.PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        dfs(s, 0, new ArrayList<>(), res);
        return res;
    }

    private void dfs(String s, int i, List<String> part, List<List<String>> res) {
        if(i >= s.length()) {
            res.add(new ArrayList<>(part));
            return;
        }

        for(int j = i; j < s.length(); j++) {
            if(isPalin(s.substring(i, j+1))) {
                part.add(s.substring(i, j+1));
                dfs(s, j + 1, part, res);
                part.remove(part.size() - 1);
            }
        }
    }

    private boolean isPalin(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<String>> res = sol.partition("aab");
        for(List<String> list : res) {
            for(String s : list)
                System.out.print(s + " ");
            System.out.println();
        }
    }
}
