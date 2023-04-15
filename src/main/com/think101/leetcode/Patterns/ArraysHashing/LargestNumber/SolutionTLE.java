package main.com.think101.leetcode.Patterns.ArraysHashing.LargestNumber;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionTLE {
    private List<List<Integer>> res = new ArrayList<>();

    public String largestNumber(int[] nums) {
        String largest = "";

        List<List<Integer>> permutes = permute(nums);
        for(List<Integer> l : permutes) {
            String s = String.join("", l.stream().map(Object::toString).toArray(String[]::new));

            if(largest.compareTo(s) < 0) {
                largest = s;
            }
        }

        return largest;

    }

    private List<List<Integer>> permute(int[] nums) {
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
        SolutionTLE s = new SolutionTLE();
        int[] nums = {3, 30, 34, 5, 9};
        System.out.println(s.largestNumber(nums));
    }
}
