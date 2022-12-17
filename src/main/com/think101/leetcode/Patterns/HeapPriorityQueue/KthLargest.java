package main.com.think101.leetcode.Patterns.HeapPriorityQueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthLargest {
    List<Integer> all;
    int kth;

    public KthLargest(int k, int[] nums) {
        all = new ArrayList<>();
        kth = k;

        for (int num : nums) {
            all.add(num);
        }
    }

    public int add(int val) {
        all.add(val);
        Collections.sort(all);
        return all.get(all.size() - kth);
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
