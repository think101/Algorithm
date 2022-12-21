package main.com.think101.leetcode.Patterns.HeapPriorityQueue.KClosestPointsToOrigin;

import java.util.PriorityQueue;

public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(k,
                (a, b) -> b[0] * b[0] + b[1] * b[1] - a[0] * a[0] - a[1] * a[1]);

        for(int[] p : points) {
            if(pq.size() < k) {
                pq.add(p);
            }
            else {
                int[] t = pq.peek();
                if(p[0] * p[0] + p[1] * p[1] - t[0] * t[0] - t[1] * t[1] < 0) {
                    pq.poll();
                    pq.add(p);
                }
            }
        }

        int[][] res = new int[k][2];
        for(int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] points = new int[][]{{1,3},{-2,2}};
        int k = 1;
        int[][] res = s.kClosest(points, k);
        for(int[] p : res) {
            System.out.println(p[0] + ", " + p[1]);
        }
    }
}
