package main.com.think101.leetcode.contest.Sum3Closest;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];

        for(int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            while(j < k) {
                int t = nums[i] + nums[j] + nums[k];
                if(Math.abs(result - target) > Math.abs(t - target)) {
                    result = t;
                }

                if( t < target){
                    j++;
                }
                else {
                    k--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.threeSumClosest(new int[]{1, 1, -1, -1, 3}, -1));

    }
}