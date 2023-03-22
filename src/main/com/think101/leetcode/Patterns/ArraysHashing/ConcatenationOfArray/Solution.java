package main.com.think101.leetcode.Patterns.ArraysHashing.ConcatenationOfArray;

public class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] res = new int[nums.length * 2];

        for(int i = 0; i < nums.length; i++) {
            res[i] = res[i + nums.length] = nums[i];
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1,2,1};
        int[] res = s.getConcatenation(nums);
        for(int i : res)
            System.out.print(i + " ");
    }
}
