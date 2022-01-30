package main.com.think101.leetcode.FindFirstLastPositionInSortedArray;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        int a = -1, b = -1;

        while(left <= right) {
            int middle = left + (right+1-left)/2;
            if(target == nums[middle]) {
                int t = middle;
                while(t-1 >=0 && nums[t-1] == nums[middle])
                    t--;
                a = t;

                t = middle;
                while(t+1 < nums.length && nums[t+1] == nums[middle])
                    t++;
                b = t;

                return new int[]{a, b};
            }

            // not needed
//            int k = right;
//            while(k-1 >=0 && nums[k-1] == nums[right])
//                k--;
//            right = k;
//
//            k = left;
//            while(k+1 < nums.length && nums[k+1] == nums[left])
//                k++;
//            left = k;k

            if(target < nums[middle]) {
                right = middle-1;
            }
            else {
                left = middle+1;
            }
        }

        return new int[]{a, b};
    }
}
