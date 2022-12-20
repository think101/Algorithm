package main.com.think101.leetcode.Patterns.HeapPriorityQueue.LastStoneWeight;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(stones.length, Collections.reverseOrder());

        for(int n : stones) {
            pq.add(n);
        }

        while(pq.size() > 0) {
            int t1 = pq.poll();

            if(pq.size() == 0) return t1;

            int t2 = pq.poll();
            if(t1 != t2) {
                pq.add(t1 - t2);
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }
}
