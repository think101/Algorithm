package main.com.think101.leetcode.Patterns.ArraysHashing.ReorganizeString;

import java.util.*;

public class Solution {
    public String reorganizeString(String s) {
        TreeMap<Integer, List<Character>> cntToChars = new TreeMap<>(Comparator.reverseOrder());
        int[] cnts = new int[26];

        for(int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(cnts[i] == 0) continue;

            if(!cntToChars.containsKey(cnts[i])){
                cntToChars.put(cnts[i], new ArrayList<>());
            }

            cntToChars.get(cnts[i]).add((char)('a' + i));
        }

        if(cntToChars.firstKey() - 1 > s.length() - cntToChars.firstKey()) return "";

        StringBuilder sb = new StringBuilder();

        while(cntToChars.size() > 0) {
            for(Map.Entry<Integer, List<Character>> entry : cntToChars.entrySet()) {
                List<Character> chars = entry.getValue();
                for(char c : chars) {
                    sb.append(c);
                }
            }

            for(int i = 1; i < cntToChars.firstKey(); i++){
                cntToChars.put(i, cntToChars.get(i + 1));
            }

            cntToChars.remove(cntToChars.firstKey());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reorganizeString("vvvlo"));
    }
}