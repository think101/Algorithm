package main.com.think101.leetcode.Patterns.BackTrack.Combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        dfs(0, n, k, new ArrayList<>());
        return res;
    }


    private void dfs(int ind, int n, int k, List<Integer> visited) {
        if(k < 0) return;
        if(k == 0) {
            res.add(new ArrayList<>(visited));
            return;
        }

        for(int j = ind + 1; j <= n; j++ ){
            visited.add(j);
            dfs(j, n, k - 1, visited);
            visited.remove(visited.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combine(4, 2));
    }

}
