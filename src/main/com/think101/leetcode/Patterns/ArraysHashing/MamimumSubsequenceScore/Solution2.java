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

        long sum = 0;
        for(int i = 0; i < k; i++) {
            int index = sortedIndex[i];
            sum += nums1[index];
            minHeap.add(index);
        }

        long res = sum * nums2[sortedIndex[k - 1]];

        for(int i = k; i < nums2.length; i++) {
            int index = sortedIndex[i];
            sum += nums1[index];

            minHeap.add(index);
            sum -= nums1[minHeap.poll()];

            res = Math.max(res, sum * nums2[index]);

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
