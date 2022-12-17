package main.com.think101.leetcode.Patterns.HeapPriorityQueue;

import java.util.TreeSet;

public class KthLargest {
    TreeSet<Integer> tSet;
    int kth;

    public KthLargest(int k, int[] nums) {
        tSet = new TreeSet<>();
        kth = k;

        for(int i = 0; i < nums.length; i++) {
            tSet.add(nums[i]);
        }
    }

    public int add(int val) {
        tSet.add(val);
        return tSet.get(tSet.size() - kth);
    }
}
