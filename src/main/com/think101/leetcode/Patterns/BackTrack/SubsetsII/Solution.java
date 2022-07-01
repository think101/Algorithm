package main.com.think101.leetcode.Patterns.BackTrack.SubsetsII;

import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
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

        while(i + 1 < nums.length && nums[i + 1] == nums[i])
            i++;
        backtrack(nums, i + 1, subset, result);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = s.subsetsWithDup(nums);
        for(List<Integer> l : res) {
            for(int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
