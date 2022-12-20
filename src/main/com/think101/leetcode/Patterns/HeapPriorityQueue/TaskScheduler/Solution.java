package main.com.think101.leetcode.Patterns.HeapPriorityQueue.TaskScheduler;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] cnts = new int[26];
        Queue<int[]> taskQ = new LinkedList<>();

        for (char c : tasks) {
            cnts[c - 'A']++;
        }

        for(int i = 0; i < 26; i++) {
            if(cnts[i] > 0) {
                pq.add(cnts[i]);
            }
        }

        int t = 0;
        while(taskQ.size() > 0 || pq.size() > 0) {
            if(taskQ.size() > 0 && taskQ.peek()[1] <= t) {
                int[] task = taskQ.poll();
                pq.add(task[0]);
            }

            if(pq.size() > 0) {
                int cnt = pq.poll();

                if(cnt > 1) {
                    taskQ.add(new int[]{cnt - 1, t + 1 + n});
                }
            }

            t++;
        }

        return t;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.leastInterval(new char[]{'A','A','A','B','B','B'}, 0));
    }
}
