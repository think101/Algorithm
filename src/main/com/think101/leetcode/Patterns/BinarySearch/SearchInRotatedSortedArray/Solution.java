package main.com.think101.leetcode.Patterns.BinarySearch.SearchInRotatedSortedArray;

public class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while(l <= r) {
            int m = (l + r) / 2;
            if(nums[m] == target) return m;

            // in left part
            if(nums[m] >= nums[l]) {
                if(target > nums[m] || target < nums[l]) {
                    l = m + 1;
                }
                else {
                    r = m - 1;
                }
            }
            // in right part
            else {
                if(target < nums[m] || target > nums[r]) {
                    r = m - 1;
                }
                else {
                    l = m + 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.search(new int[] {4, 5, 6, 7, 0, 1, 2}, 0));
    }
}