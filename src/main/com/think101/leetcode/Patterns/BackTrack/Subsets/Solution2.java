package main.com.think101.leetcode.Patterns.BackTrack.Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(new ArrayList<>(), 0, nums);
        return res;
    }

    private void backtrack(List<Integer> curr, int i, int[] nums) {
        if(i == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        backtrack(curr, i+1, nums);
        curr.add(nums[i]);
        backtrack(curr, i+1, nums);
        curr.remove(curr.size() - 1);
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = s.subsets(nums);
        for(List<Integer> l : res) {
            for(int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
