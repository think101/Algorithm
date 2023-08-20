package main.com.think101.leetcode.Patterns.SlidingWindow.SlidingWindowMaximum;

import java.util.Collections;
import java.util.PriorityQueue;

public class SolutionLTE2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] res = new int[nums.length - k + 1];

        for(int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }
        res[0] = pq.peek();

        for(int i = k; i < nums.length; i++) {
            pq.remove(nums[i - k]);
            pq.add(nums[i]);

            res[i - k + 1] = pq.peek();
        }

        return res;
    }

    public static void main(String[] args) {
        SolutionLTE2 s = new SolutionLTE2();
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] res = s.maxSlidingWindow(nums, 3);
        for(int i : res) {
            System.out.print(i + " ");
        }
    }
}
