package main.com.think101.leetcode.Patterns.ArraysHashing.MamimumSubsequenceScore;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Integer> miniHeap = new PriorityQueue<>(Comparator.comparingInt(index -> nums2[index]));
        int currentSum = 0;

        for(int i = 0; i < k; i++) {
            miniHeap.add(i);
            currentSum += nums1[i];
        }

        for(int i = k; i < nums1.length; i++) {
            int t = miniHeap.peek();

            if(nums2[i] < nums2[t] && nums1[i] < nums1[t]) continue;
            else if (nums2[i] > nums2[t] && nums1[i] > nums1[t]) {
                miniHeap.poll();
                miniHeap.add(i);
                currentSum = currentSum - nums1[t] + nums1[i];
            }
            else {
                miniHeap.poll();
                miniHeap.add(i);

                if((currentSum - nums1[t] + nums1[i]) * nums2[miniHeap.peek()] > currentSum * nums2[t]) {
                    currentSum = currentSum - nums1[t] + nums1[i];
                }
                else {
                    miniHeap.remove(i);
                    miniHeap.add(t);
                }
            }
        }

        return currentSum * nums2[miniHeap.peek()];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = {1,3,3,2};
        int[] nums2 = {2,1,3,4};
        System.out.println(s.maxScore(nums1, nums2, 3));
    }
}
