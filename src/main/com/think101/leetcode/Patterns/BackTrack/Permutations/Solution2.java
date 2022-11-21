package main.com.think101.leetcode.Patterns.BackTrack.Permutations;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            Set<Integer> s = new HashSet<>();
            s.add(i);
            List<Integer> l = new ArrayList<>();
            l.add(nums[i]);
            bt(nums, s, l);
        }

        return res;
    }

    private void bt(int[] nums, Set<Integer> visited, List<Integer> curr) {
        if(curr.size() == nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!visited.contains(i)) {
                visited.add(i);
                curr.add(nums[i]);

                bt(nums, visited, curr);

                visited.remove(i);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = s.permute(nums);
        for(List<Integer> l : res) {
            for(int i : l) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}