package main.com.think101.leetcode.Patterns.BackTrack.SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        bt(nums, 0, new ArrayList<>());

        return res;
    }

    private void bt(int[] nums, int i, List<Integer> curr) {
        if(i >= nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[i]);
        bt(nums, i + 1, curr);
        curr.remove(curr.size() - 1);

        while(i + 1 < nums.length && nums[i+1] == nums[i]) i++;
        bt(nums, i + 1, curr);
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
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
