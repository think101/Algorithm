package main.com.think101.leetcode.Patterns.HeapPriorityQueue;

import java.util.TreeSet;

public class KthLargest {
    TreeSet<Integer> tSet;
    int kth;

    public KthLargest(int k, int[] nums) {
        tSet = new TreeSet<>();
        kth = k;

        for (int num : nums) {
            tSet.add(num);
        }
    }

    public int add(int val) {
        tSet.add(val);
        return tSet.toArray(new Integer[0])[tSet.size() - kth];
    }

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4,5,8,2});
        System.out.println(kthLargest.add(3));   // returns 4
        System.out.println(kthLargest.add(5));   // returns 5
        System.out.println(kthLargest.add(10));  // returns 5
        System.out.println(kthLargest.add(9));   // returns 8
        System.out.println(kthLargest.add(4));   // returns 8
    }
}
