package main.com.think101.leetcode.Patterns.ArraysHashing.LargestNumber;

import java.util.Arrays;

public class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder sb = new StringBuilder();
        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(arr, (a, b) -> {
            String s1 = String.valueOf(a);
            String s2 = String.valueOf(b);
            return (s2 + s1).compareTo(s1 + s2);
        });
        if (arr[0] == 0) {
            return "0";
        }
        sb.setLength(0);
        for (int num : arr) {
            sb.append(num);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largestNumber(new int[]{10, 2}));
        System.out.println(s.largestNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
