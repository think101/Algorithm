package main.com.think101.leetcode.Patterns.BackTrack.SubsetsII;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        return helper(nums, 0);
    }

    List<List<Integer>> helper(int[] nums, int i) {
        if(i == nums.length) {
            List<Integer> l = new ArrayList<>();
            List<List<Integer>> res = new ArrayList<>();
            res.add(l);

            return res;
        }

        List<List<Integer>> prev = helper(nums, i + 1);
        List<List<Integer>> result = new ArrayList<>(prev);

        for(List<Integer> l : prev){
            List<Integer> c = new ArrayList<>(l);
            c.add(nums[i]);
            result.add(c);
        }

        return result;
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
