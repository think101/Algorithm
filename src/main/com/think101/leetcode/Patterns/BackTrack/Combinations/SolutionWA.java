package main.com.think101.leetcode.Patterns.BackTrack.Combinations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class SolutionWA {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        helper(n, 0, k, new HashSet<>());

        return res;
    }

    private void helper(int n, int curr, int k, Set<Integer> visited) {
        if(k < 0) return;
        if(k == 0) {
            res.add(new ArrayList<>(visited));
            return;
        }

        for(int i = curr + 1; i <= n; i++) {            
            visited.add(i);
            helper(n, i, k - 1, visited);
            visited.remove(i);
        }
    }

    public static void main(String[] args) {
        SolutionWA s = new SolutionWA();
        System.out.println(s.combine(4, 2));
    }
}
