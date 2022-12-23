package main.com.think101.leetcode.Patterns.HeapPriorityQueue.FindMedianFromDataStream;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        minHeap.add(num);

        if(minHeap.size() - maxHeap.size() > 1) {
            int t = minHeap.poll();
            maxHeap.add(t);
        }
    }

    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
        else if(minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        }
        else {
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {
        MedianFinder s = new MedianFinder();
        s.addNum(-1);
        System.out.println(s.findMedian());
        s.addNum(-2);
        System.out.println(s.findMedian());
        s.addNum(-3);
        System.out.println(s.findMedian());
        s.addNum(-4);
        System.out.println(s.findMedian());
        s.addNum(-5);
        System.out.println(s.findMedian());
    }
}
