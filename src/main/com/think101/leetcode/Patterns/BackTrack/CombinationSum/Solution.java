package main.com.think101.leetcode.Patterns.BackTrack.CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        dfs(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] cands, int target, int index, List<Integer> visited) {
        if(target == 0) {
            res.add(new ArrayList<>(visited));
            return;
        }
        else if(target < 0){
            return;
        }

        for(int i = index; i < cands.length; i++) {
            visited.add(cands[i]);
            dfs(cands, target - cands[i], i, visited);
            visited.remove(visited.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combinationSum(new int[]{2,3,6,7}, 7));
    }
}