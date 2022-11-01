package main.com.think101.leetcode.Patterns.BinarySearch;

public class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length;

        while(l < r) {
            int m = (l + r) / 2;
            if(nums[m] == target) return m;
            else if(nums[m] < target) l++;
            else r--;
        }

        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.search(new int[] {1, 2, 3, 4, 5}, 3));
    }
}
