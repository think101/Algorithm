package main.com.think101.leetcode.Patterns.BinarySearch.MedianOfTwoSortedArrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int l1 = nums1.length, l2 = nums2.length;
        int m = (l1 + l2) / 2;
        boolean even = ( l1 + l2 ) % 2 == 0;

        int curr = -1, prevVal = -1, currVal = -1;

        while(i < l1 && j < l2) {
            if(nums1[i] < nums2[j]) {
                prevVal = currVal;
                currVal = nums1[i];
                i++;
            }
            else {
                prevVal = currVal;
                currVal = nums2[j];
                j++;
            }

            curr++;

            if(curr == m) {
                if(!even) return currVal;
                else return (prevVal * 1.0 + currVal) / 2;
            }
        }

        while( i < l1 ){
            prevVal = currVal;
            currVal = nums1[i];
            i++;

            curr++;

            if(curr == m) {
                if(!even) return currVal;
                else return (prevVal * 1.0 + currVal) / 2;
            }
        }

        while( j < l2 ){
            prevVal = currVal;
            currVal = nums2[j];
            j++;

            curr++;

            if(curr == m) {
                if(!even) return currVal;
                else return (prevVal * 1.0 + currVal) / 2;
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMedianSortedArrays(new int[] {}, new int[] {2, 3}));
    }
}
