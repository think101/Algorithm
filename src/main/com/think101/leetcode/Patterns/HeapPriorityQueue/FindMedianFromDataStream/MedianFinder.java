package main.com.think101.leetcode.Patterns.HeapPriorityQueue.FindMedianFromDataStream;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    private final PriorityQueue<Integer> minHeap;
    private final PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        maxHeap.add(num);

        if(maxHeap.size() - minHeap.size() > 1) {
            int t = maxHeap.poll();
            minHeap.add(t);
        }

        if(minHeap.size() > 0 && maxHeap.peek() > minHeap.peek()) {
            int t1 = maxHeap.poll();
            int t2 = minHeap.poll();
            maxHeap.add(t2);
            minHeap.add(t1);
        }
    }

    public double findMedian() {
        if(minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
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
