package main.com.think101.leetcode.Patterns.ArraysHashing.LargestNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public String largestNumber(int[] nums) {

        List<Integer> sorted = Arrays.stream(nums).boxed().sorted((a, b) -> {
            String s1 = a + b.toString();
            String s2 = b + a.toString();
            return s2.compareTo(s1);
        }).collect(Collectors.toList());

        String res = sorted.stream().map(Object::toString).reduce("", (a, b) -> a + b);
        res = res.replaceFirst("^0+", "");

        return res.isEmpty() ? "0" : res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largestNumber(new int[]{10, 2}));
        System.out.println(s.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
