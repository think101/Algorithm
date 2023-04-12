package main.com.think101.leetcode.Patterns.ArraysHashing.LargestNumber;

import java.util.TreeSet;

public class Solution {
    public String largestNumber(int[] nums) {
        TreeSet<String> s = new TreeSet<>();

        for(int i : nums) {
            s.add(String.valueOf(i));
        }

        StringBuilder sb = new StringBuilder();
        while(s.size() > 0) {
            sb.append(s.pollLast());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largestNumber(new int[]{10, 2}));
        System.out.println(s.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
