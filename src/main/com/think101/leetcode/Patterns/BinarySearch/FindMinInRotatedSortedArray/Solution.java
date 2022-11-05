package main.com.think101.leetcode.Patterns.BinarySearch.FindMinInRotatedSortedArray;

public class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1) return nums[0];

        int l = 0, r = nums.length - 1;

        while( l <= r) {
            int m = (l + r) / 2;

            if(nums[m] > nums[nums.length - 1]) {
                l = m + 1;
            }
            else {
                r = m - 1;
            }
        }

        return nums[l];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMin(new int[] {3, 4, 5, 1, 2}));
    }
}
