package main.com.think101.leetcode.contest.Test296.PartitionArrayMaxDiffK;

import java.util.Arrays;

class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;

        int i = 0;
        int res = 0;
        while(true) {
            if(i >= len)
                break;

            int t = i;
            while(i+1 < len && nums[i+1] - nums[t] <= k )
                i++;

            i += 1;
            res += 1;
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3,6,1,2,5};
        System.out.println(s.partitionArray(nums, 2));

        nums = new int[]{1,2,3};
        System.out.println(s.partitionArray(nums, 1));

        nums = new int[]{2,2,4,5};
        System.out.println(s.partitionArray(nums, 0));
    }
}
