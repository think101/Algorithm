package main.com.think101.leetcode.Patterns.LinkedList.FindTheDuplicateNumber;

public class Solution {
    public int findDuplicate(int[] nums) {
        int fast = 0, slow = 0;

        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }

        int slow2 = 0;
        while(true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if(slow == slow2) break;
        }

        return slow;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1,3,4,2,2};
        System.out.println(s.findDuplicate(nums));
    }
}