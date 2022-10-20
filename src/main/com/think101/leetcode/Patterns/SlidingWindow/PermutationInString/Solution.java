package main.com.think101.leetcode.Patterns.SlidingWindow.PermutationInString;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1Cnt = new HashMap<>();
        Map<Character, Integer> s2Cnt = new HashMap<>();

        for(int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if(!s1Cnt.containsKey(c))
                s1Cnt.put(c, 0);

            s1Cnt.put(c, s1Cnt.get(c) + 1);
        }

        for(int i = 0; i < s1.length(); i++) {
            if(i >= s2.length()) break;
            char c = s2.charAt(i);
            if(!s2Cnt.containsKey(c))
                s2Cnt.put(c, 0);

            s2Cnt.put(c, s2Cnt.get(c) + 1);
        }

        if(checkCnt(s1Cnt, s2Cnt)) return true;

        for(int i = 1; i < s2.length(); i++) {
            if(i + s1.length() - 1 >= s2.length()) break;

            char addChar = s2.charAt(i + s1.length() - 1);
            char removeChar = s2.charAt(i-1);

            if(!s2Cnt.containsKey(addChar))
                s2Cnt.put(addChar, 1);
            else
                s2Cnt.put(addChar, s2Cnt.get(addChar) + 1);

            if(s2Cnt.get(removeChar) == 1)
                s2Cnt.remove(removeChar);
            else
                s2Cnt.put(removeChar, s2Cnt.get(removeChar) - 1);

            if(checkCnt(s1Cnt, s2Cnt)) return true;
        }

        return false;
    }

    private boolean checkCnt(Map<Character, Integer> s1Cnt, Map<Character, Integer> s2Cnt) {
        if(s1Cnt.size() != s2Cnt.size()) {
            return false;
        }

        for(char c : s2Cnt.keySet()) {
            if(!s1Cnt.containsKey(c) || !s1Cnt.get(c).equals(s2Cnt.get(c))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.checkInclusion("hello", "ooolleoooleh"));
    }
}