package main.com.think101.leetcode.Patterns.HeapPriorityQueue.ReorganizeString;

import java.util.PriorityQueue;

public class Solution2 {
    public String reorganizeString(String s) {
        int[] cnt = new int[26];
        for(int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (arr1, arr2) -> Integer.compare(arr2[0], arr1[0]));
        for(int i = 0; i < 26; i++) {
            if(cnt[i] != 0) {
                pq.add(new int[]{cnt[i], i});
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            int[] t1 = pq.poll();
            if(t1[0] > 1 && pq.isEmpty()) {
                return "";
            }
            else if(t1[0] == 1 && pq.isEmpty()){
                sb.append((char)('a' + t1[1]));
                return sb.toString();
            }
            else {
                int[] t2 = pq.poll();
                sb.append((char)('a' + t1[1]));
                sb.append((char)('a' + t2[1]));

                if(t1[0] - 1 > 0) {
                    pq.add(new int[]{t1[0] - 1, t1[1]});
                }

                if(t2[0] - 1 > 0) {
                    pq.add(new int[]{t2[0] - 1,  t2[1]});
                }
            }
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.reorganizeString("aab"));
    }
}
