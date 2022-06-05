package main.com.think101.leetcode.contest.Test296.MinMaxGame;

class Solution {
    public int minMaxGame(int[] nums) {
        int len = nums.length;

        while(len > 1) {
            int i = 0;
            while(i < len) {
                if((i/2) % 2 == 0) {
                    if(i+1 < len) {
                        nums[i/2] = Math.min(nums[i], nums[i+1]);
                    }
                    else {
                        nums[i/2] = nums[i];
                    }
                }
                else {
                    if(i+1 < len) {
                        nums[i/2] = Math.max(nums[i], nums[i+1]);
                    }
                    else {
                        nums[i/2] = nums[i];
                    }
                }

                i += 2;
            }

            len = i/2;
        }

        return nums[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {70, 38, 21, 22};
        System.out.println(s.minMaxGame(nums));
        nums = new int[]{1, 3, 5, 2, 4, 8, 2, 2};
        System.out.println(s.minMaxGame(nums));
    }
}