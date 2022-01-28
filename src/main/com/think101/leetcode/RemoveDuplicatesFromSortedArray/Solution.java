package main.com.think101.leetcode.RemoveDuplicatesFromSortedArray;

public class Solution {

    public int removeDuplicates(int[] nums) {
        int k = 0;
        int current = 0;

        for(int i=0; i<nums.length; i++) {
            while(i+1 <nums.length && nums[i+1] == nums[i]) {
                i++;
            }
            nums[k++] = nums[i];
        }

        return k;
    }
}
