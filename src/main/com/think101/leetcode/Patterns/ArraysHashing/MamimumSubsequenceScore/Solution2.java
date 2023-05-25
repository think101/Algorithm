package main.com.think101.leetcode.Patterns.ArraysHashing.MamimumSubsequenceScore;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer> sortedIndex = new PriorityQueue<>(Comparator.comparingInt(index -> -nums2[index]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(index -> -nums1[index]));

        for(int i = 0; i < nums2.length; i++) {
            sortedIndex.add(i);
        }

        int sum = 0;
        int prevIndex = -1;
        for(int i = 0; i < k; i++) {
            int index = sortedIndex.poll();
            sum += nums1[index];
            minHeap.add(index);

            prevIndex = index;
        }


        for(int i = k; i < nums2.length; i++) {
            int index = sortedIndex.poll();

            int num1MinIndex = minHeap.peek();

            if(sum * nums2[prevIndex] < (sum - nums1[num1MinIndex] + nums1[index]) * nums2[index]) {
                sum = sum - nums1[num1MinIndex] + nums1[index];
                minHeap.poll();
                minHeap.add(index);
            }

            prevIndex = index;
        }

        return sum * nums2[minHeap.peek()];
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] nums1 = {4, 2, 3, 1, 1};
        int[] nums2 = {7, 5, 10, 9, 6};
        System.out.println(s.maxScore(nums1, nums2, 1));
    }

}
