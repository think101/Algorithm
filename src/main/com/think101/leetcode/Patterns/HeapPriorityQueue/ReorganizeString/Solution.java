package main.com.think101.leetcode.Patterns.HeapPriorityQueue.ReorganizeString;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public String reorganizeString(String s) {
        int[] cnts = new int[26];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        StringBuilder sb = new StringBuilder();
        List<int[]> waitList = new ArrayList<>();

        int t = 0;
        for(int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if(cnts[i] != 0) {
                pq.add(new int[]{i, cnts[i], t});
            }
        }

        while(waitList.size() > 0 || pq.size() > 0){
            if(waitList.size() > 0 && waitList.get(0)[2] <= t){
                pq.add(waitList.get(0));
                waitList.remove(0);
            }

            if(pq.size() > 0 ) {
                int[] elem = pq.poll();
                elem[1] = elem[1] - 1;
                elem[2] = t + 2;
                if(sb.length() > 0 && sb.charAt(sb.length() - 1) - 'a' == elem[0]) {
                    return "";
                }
                else {
                    sb.append((char)(elem[0] + 'a'));

                    if(elem[1] > 0) {
                        waitList.add(elem);
                    }
                }
            }

            t++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "aab";
        System.out.println(s.reorganizeString(str));
    }
}
