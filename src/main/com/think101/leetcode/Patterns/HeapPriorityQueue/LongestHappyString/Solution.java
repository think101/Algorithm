package main.com.think101.leetcode.Patterns.HeapPriorityQueue.LongestHappyString;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((m, n) -> n[1] - m[1]);
        List<int[]> q = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int t = 0;

        pq.add(new int[]{0, a, 0});
        pq.add(new int[]{1, b, 0});
        pq.add(new int[]{2, c, 0});

        while(pq.size() > 0 || q.size() > 0) {
            if(q.size() > 0 && q.get(0)[2] <= t) {
                int[] elem = q.get(0);
                q.remove(0);
                pq.add(elem);
            }

            if(pq.size() > 0) {
                int[] elem = pq.poll();
                char ch = (char)(elem[0] + 'a');
                if(sb.length() > 1 && sb.charAt(sb.length() - 1) == ch && sb.charAt(sb.length() - 2) == ch) {
                    if(elem[1] > 0) {
                        q.add(new int[]{elem[0], elem[1], t + 2});
                    }
                }
                else {
                    if(elem[1] > 0) {
                        sb.append(ch);
                    }


                    if(elem[1] - 1 > 0) {
                        pq.add(new int[]{elem[0], elem[1] - 1,  t + 1});
                    }
                }
            }

            if(t > a + b + c) break;
            t++;
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestDiverseString(7, 1, 0));
    }
}
