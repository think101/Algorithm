package main.com.think101.leetcode.Patterns.ArraysHashing.SortColors;

public class Solution {
    public void sortColors(int[] nums) {
        int[] cnts = new int[3];
        for(int i : nums) {
            cnts[i]++;
        }

        for(int i = 0; i < nums.length; i++) {
            if(i < cnts[0]) nums[i] = 0;
            else if( i < cnts[0] + cnts[1]) nums[i] = 1;
            else nums[i] = 2;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{2,0,2,1,1,0};
        s.sortColors(nums);
        for(int i : nums)
            System.out.print(i + " ");
    }
}