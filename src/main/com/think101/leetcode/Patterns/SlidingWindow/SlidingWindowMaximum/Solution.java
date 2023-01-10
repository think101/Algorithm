package main.com.think101.leetcode.Patterns.SlidingWindow.SlidingWindowMaximum;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<>();    // the idea of keeping the index instead of the value is brilliant

        for(int i = 0; i < k; i++) {
            if(dq.size() == 0) dq.addLast(i);
            else {
                while(dq.size() > 0 && nums[i] > nums[dq.peekLast()]) {
                    dq.removeLast();
                }

                dq.addLast(i);
            }
        }
        res[0] = nums[dq.peekFirst()];

        for(int i = k; i < nums.length; i++) {
            if(dq.peekFirst() == i - k) dq.removeFirst();
            while(dq.size() > 0 && nums[i] > nums[dq.peekLast()]) {
                dq.removeLast();
            }

            dq.addLast(i);
            res[i - k + 1] = nums[dq.peekFirst()];
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        int[] res = s.maxSlidingWindow(nums, 3);
        for(int i : res) {
            System.out.print(i + " ");
        }
    }
}