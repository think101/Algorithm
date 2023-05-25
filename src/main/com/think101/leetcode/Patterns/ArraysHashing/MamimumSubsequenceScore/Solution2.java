package main.com.think101.leetcode.Patterns.ArraysHashing.MamimumSubsequenceScore;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        Integer[] sortedIndex = new Integer[nums2.length];
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(index -> nums1[index]));

        for(int i = 0; i < nums2.length; i++) {
            sortedIndex[i] = i;
        }

        Arrays.sort(sortedIndex, Comparator.comparingInt(index -> -nums2[(int) index]));

        int sum = 0;
        for(int i = 0; i < k; i++) {
            int index = sortedIndex[i];
            sum += nums1[index];
            minHeap.add(index);
        }

        int res = sum * nums2[sortedIndex[k - 1]];

        for(int i = k; i < nums2.length; i++) {
            int index = sortedIndex[i];

            int num1MinIndex = minHeap.peek();

            if(res < (sum - nums1[num1MinIndex] + nums1[index]) * nums2[index]) {
                sum = sum - nums1[num1MinIndex] + nums1[index];
                res = sum * nums2[index];
                minHeap.poll();
                minHeap.add(index);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] nums1 = {1, 4};
        int[] nums2 = {3, 1};
        System.out.println(s.maxScore(nums1, nums2, 2));
    }

}
