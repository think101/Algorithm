package main.com.think101.leetcode.MergeSortedArray;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k = m+n-1;
        while(m-1>=0 || n-1>=0 ) {
            if(m-1>=0 && n-1>=0) {
                if(nums1[m-1]>nums2[n-1]) {
                    nums1[k--] = nums1[m-1];
                    m--;
                }
                else {
                    nums1[k--] = nums2[n-1];
                    n--;
                }
            }
            else if(m-1>=0) {
                nums1[k--] = nums1[m-1];
                m--;
            }
            else {
                nums1[k--] = nums2[n-1];
                n--;
            }
        }
    }
}
