package main.com.think101.leetcode.Patterns.BackTrack.CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(new ArrayList<>(), 0, candidates, target);

        return res;
    }

    private void backtrack(List<Integer> curr, int i, int[] candidates, int target) {
        int s = sum(curr);
        if(s > target) return;
        else if(s == target) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if(i >= candidates.length ) return;

        curr.add(candidates[i]);
        backtrack(curr, i, candidates, target);
        curr.remove(curr.size() - 1);
        backtrack(curr, i + 1, candidates, target);
    }

    private int sum(List<Integer> list) {
        int s = 0;
        for (Integer integer : list) {
            s += integer;
        }

        return s;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.combinationSum(new int[]{2,3,6,7}, 7));
    }
}
