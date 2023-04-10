package main.com.think101.leetcode.Patterns.ArraysHashing.IsomorphicStrings;

import java.util.PriorityQueue;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] sCnts = new int[128];
        int[] tCnts = new int[128];
        PriorityQueue<Integer> sQueue = new PriorityQueue<>();
        PriorityQueue<Integer> tQueue = new PriorityQueue<>();

        for(int i = 0; i < s.length(); i++) {
            sCnts[s.charAt(i)]++;
            tCnts[t.charAt(i)]++;
        }

        for(int i = 0; i < 128; i++) {
            sQueue.add(sCnts[i]);
            tQueue.add(tCnts[i]);
        }

        while(sQueue.size() > 0) {
            if(!sQueue.poll().equals(tQueue.poll())) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isIsomorphic("egg", "add"));
        System.out.println(s.isIsomorphic("foo", "bar"));
        System.out.println(s.isIsomorphic("paper", "title"));
    }

}
