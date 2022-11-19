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
        if(target < 0) return;
        else if(target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if(i >= candidates.length ) return;

        curr.add(candidates[i]);
        backtrack(curr, i, candidates, target - candidates[i]);
        curr.remove(curr.size() - 1);
        backtrack(curr, i + 1, candidates, target );
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.combinationSum(new int[]{2,3,6,7}, 7));
    }
}
