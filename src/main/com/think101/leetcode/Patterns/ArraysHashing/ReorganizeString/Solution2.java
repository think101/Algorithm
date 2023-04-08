package main.com.think101.leetcode.Patterns.ArraysHashing.ReorganizeString;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {
    public String reorganizeString(String s) {
        PriorityQueue<int[]> cntAndChar = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        int[] cnts = new int[26];
        for(int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(cnts[i] == 0) continue;

            cntAndChar.add(new int[]{cnts[i], i});
        }

        int[] prev = null;
        StringBuilder sb = new StringBuilder();
        while(cntAndChar.size() > 0 || prev != null) {
            if(cntAndChar.size() == 0) return "";

            int[] curr = cntAndChar.poll();
            sb.append((char) ('a' + curr[1]));

            if(prev != null) {
                cntAndChar.add(prev);
                prev = null;
            }

            if(curr[0] > 1) {
                prev = new int[]{curr[0] - 1, curr[1]};
            }

        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.reorganizeString("aab"));
        System.out.println(s.reorganizeString("aaab"));
        System.out.println(s.reorganizeString("vvvlo"));
    }
}
