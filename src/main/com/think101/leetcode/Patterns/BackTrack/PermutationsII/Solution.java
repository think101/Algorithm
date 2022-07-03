package main.com.think101.leetcode.Patterns.BackTrack.PermutationsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        return helper(nums);
    }

    private List<List<Integer>> helper(int[] nums) {
        if(nums.length == 1) {
            List<Integer> l = new ArrayList<>();
            l.add(nums[0]);

            List<List<Integer>> res = new ArrayList<>();
            res.add(l);
            return res;
        }

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            while(i + 1 < nums.length && nums[i + 1] == nums[i])
                i++;

            // create subarray
            int[] a = new int[nums.length - 1];

            int j = 0;
            for(int k = 0; k < nums.length; k++) {
                if(k != i)
                    a[j++] = nums[k];
            }

            List<List<Integer>> r = helper(a);
            for(List<Integer> l : r) {
                l.add(nums[i]);
                result.add(l);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = s.permuteUnique(nums);
        for(List<Integer> l : res) {
            for(int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
