package main.com.think101.leetcode.Patterns.HeapPriorityQueue.KthLargestElementInStream;

import java.util.PriorityQueue;

public class PQSolution {
    private final PriorityQueue<Integer> minHeap;
    private final int kth;

    public PQSolution(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.kth = k;

        for(int i = 0; i < k && i < nums.length; i++) {
            minHeap.add(nums[i]);
        }

        for(int i = k; i < nums.length; i++) {
            if(minHeap.peek() < nums[i]) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
    }

    public int add(int val) {
        if(minHeap.size() < kth) {
            minHeap.add(val);
        }
        else if(minHeap.peek() < val) {
            minHeap.poll();
            minHeap.add(val);
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        PQSolution pqSolution = new PQSolution(3, new int[]{4,5,8,2});
        System.out.println(pqSolution.add(3));   // returns 4
        System.out.println(pqSolution.add(5));   // returns 5
        System.out.println(pqSolution.add(10));  // returns 5
        System.out.println(pqSolution.add(9));   // returns 8
        System.out.println(pqSolution.add(4));   // returns 8
    }
}
