package main.com.think101.leetcode.Permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if(nums.length == 1) {
            List<Integer> res = new ArrayList<>();
            res.add(nums[0]);
            result.add(res);
            return result;
        }

        int[] newNums = Arrays.copyOf(nums, nums.length-1);
        List<List<Integer>> res = permute(newNums);
        for(List<Integer> r : res) {
            for(int i=0; i<= r.size(); i++) {
                List<Integer> t = new ArrayList<>(r);
                t.add(i, nums[nums.length-1]);
                result.add(t);
            }
        }

        return result;
    }
}
