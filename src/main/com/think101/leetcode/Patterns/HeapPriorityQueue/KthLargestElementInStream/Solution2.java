package main.com.think101.leetcode.Patterns.HeapPriorityQueue.KthLargestElementInStream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution2 {
    final private PriorityQueue<Integer> pq;
    private final int k;

    public Solution2(int k, int[] nums) {
        this.pq = new PriorityQueue<>(Collections.reverseOrder());
        this.k = k;

        for(int n : nums) {
            pq.add(n);
        }
    }

    public int add(int val) {
        pq.add(val);

        List<Integer> tmp = new ArrayList<>();
        for(int i = 0; i < k - 1; i++) {
            tmp.add(pq.poll());
        }

        int res = pq.peek();
        for(int n : tmp) {
            pq.add(n);
        }

        return res;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2(3, new int[]{4, 5, 8, 2});
        System.out.println(s.add(3));
        System.out.println(s.add(5));
        System.out.println(s.add(10));
        System.out.println(s.add(9));
        System.out.println(s.add(4));
    }
}

/*
 * This is not a correct solution. It is just a solution to show how to use PriorityQueue.
 * The key issue is that it tries to use PriorityQueue to store all the elements, which makes it difficult
 * to find the kth element.
 * The correct way is to maintain a minHeap with size k.
 */
