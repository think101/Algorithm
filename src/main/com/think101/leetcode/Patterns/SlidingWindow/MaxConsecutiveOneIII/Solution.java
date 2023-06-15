package main.com.think101.leetcode.Patterns.SlidingWindow.MaxConsecutiveOneIII;

public class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int sum = 0, zCnt = 0;

        while(right < nums.length) {
            if(nums[right] == 0) zCnt++;
            while(zCnt > k && left < right) {
                left++;
                if(nums[left - 1] == 0) zCnt--;
            }

            if(zCnt <= k) {
                sum = Math.max(sum, right - left + 1);
            }

            right++;
        }

        return sum;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(s.longestOnes(nums, 2));
    }
}
