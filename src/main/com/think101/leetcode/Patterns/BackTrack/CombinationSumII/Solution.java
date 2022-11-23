package main.com.think101.leetcode.Patterns.BackTrack.CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        bt(candidates, new ArrayList<>(), target, 0);
        return res;
    }

    private void bt(int[] candidates, List<Integer> curr, int target, int i) {
        if(target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0 || i >= candidates.length) return;

        curr.add(candidates[i]);
        bt(candidates, curr, target - candidates[i], i+1);
        curr.remove(curr.size() - 1);

        while(i + 1 < candidates.length && candidates[i+1] == candidates[i]) i++;
        bt(candidates, curr, target, i+1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8));
    }
}
