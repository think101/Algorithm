package main.com.think101.leetcode.Patterns.LinkedList.FindTheDuplicateNumber;

public class Solution {
    public int findDuplicate(int[] nums) {
        int fast = nums[0], slow = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int slow2 = nums[0];
        while(slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1,3,4,2,2};
        System.out.println(s.findDuplicate(nums));
    }
}