package main.com.think101.leetcode.Patterns.BackTrack.Subsets;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int i, List<Integer> subset, List<List<Integer>> result) {
        if(i == nums.length) {
            List<Integer> l = new ArrayList<>(subset);
            result.add(l);
            return;
        }

        subset.add(nums[i]);
        backtrack(nums, i + 1, subset, result);
        subset.remove(subset.size() - 1);

        backtrack(nums, i + 1, subset, result);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = s.subsets(nums);
        for(List<Integer> l : res) {
            for(int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
