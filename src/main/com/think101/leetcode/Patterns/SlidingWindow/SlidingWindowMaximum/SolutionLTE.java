package main.com.think101.leetcode.Patterns.SlidingWindow.SlidingWindowMaximum;

import java.util.Collections;
import java.util.PriorityQueue;

public class SolutionLTE {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, Collections.reverseOrder());
        int[] res = new int[nums.length - k + 1];

        for(int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        int start = 0, end = k-1;
        while(end < nums.length) {
            res[start] = pq.peek();                   // O(1)
            pq.remove(nums[start++]);                 // O(k)
            end++;
            if(end < nums.length) pq.add(nums[end]);  // O(logk)
        }
        return res;
    }

    public static void main(String[] args) {
        SolutionLTE s = new SolutionLTE();
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] res = s.maxSlidingWindow(nums, 3);
        for(int i : res) {
            System.out.print(i + " ");
        }
    }
}
