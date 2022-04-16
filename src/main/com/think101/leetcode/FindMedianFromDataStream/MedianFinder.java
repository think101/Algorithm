package main.com.think101.leetcode.FindMedianFromDataStream;

import java.util.Collections;
import java.util.PriorityQueue;

class MedianFinder {
    private final PriorityQueue<Integer> large;
    private final PriorityQueue<Integer> small;

    public MedianFinder() {
        small = new PriorityQueue<>(Collections.reverseOrder());
        large = new PriorityQueue<>();
    }

    public void addNum(int num) {
        small.add(num);

        // small max value > large min value
        if(small.size() > 0 && large.size() > 0  && small.peek() > large.peek()) {
            Integer value = small.poll();
            large.add(value);
        }

        if(small.size() > large.size() + 1) {
            Integer value = small.poll();
            large.add(value);
        }
        else if (small.size() + 1 < large.size()) {
            Integer value = large.poll();
            small.add(value);
        }
    }

    public double findMedian() {
        if(small.size() > large.size())
            return small.peek();
        else if(small.size() < large.size())
            return large.peek();
        else
            return (small.peek() + large.peek()) / 2.0;
    }

    public static void main(String[] args) {
        MedianFinder mf = new MedianFinder();
        mf.addNum(6);
        mf.addNum(10);
        System.out.println(mf.findMedian());
        mf.addNum(2);
        System.out.println(mf.findMedian());
    }
}

