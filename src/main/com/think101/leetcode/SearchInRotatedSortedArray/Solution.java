package main.com.think101.leetcode.SearchInRotatedSortedArray;

public class Solution {

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int target = 2;

        System.out.println(search(nums, target));
    }

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length-1;

        while(left <= right) {
            int middle = left + (right+1-left)/2;
            if(nums[middle] == target)
                return middle;

            if(nums[left] > nums[right]) {
                // rotated
                if(nums[middle] > nums[left]) {
                    // left portion
                    if( target < nums[middle]) {
                        if(target <= nums[right]) {    // edge case when target is the most right index
                            left = middle + 1;
                        }
                        else {
                            right = middle - 1;
                        }
                    }
                    else {
                        left = middle + 1;
                    }
                }
                else {
                    // right portion
                    if( target < nums[middle]) {
                        right = middle-1;
                    }
                    else {
                        if(target > nums[right]) {
                            right = middle - 1;
                        }
                        else {
                            left = middle + 1;
                        }
                    }
                }
            }
            else {
                // not rotated
                if(target < nums[middle]) {
                    right = middle-1;
                }
                else {
                    left = middle+1;
                }
            }

        }

        return -1;
    }
}
