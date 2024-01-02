package main.com.think101.leetcode.Patterns.ArraysHashing.ContainsDuplicate;

public class Solution2 {
    public boolean containsDuplicate(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i : nums) {
            max = Math.max(max, i);
            min = Math.min(min, i);
        }

        boolean[] arr = new boolean[max - min + 1];

        for(int i : nums) {
            if(arr[i - min]) return true;
            arr[i - min] = true;
        }

        return false;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.containsDuplicate(new int[]{1,2,3,1}));
        System.out.println(s.containsDuplicate(new int[]{1,2,3,4}));
        System.out.println(s.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}));
    }
}
