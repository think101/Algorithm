package main.com.think101.leetcode.Patterns.ArraysHashing.ContainsDuplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>();

        for(int i : nums)
            if(!s.add(i))
                return true;

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(s.containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(s.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }
}