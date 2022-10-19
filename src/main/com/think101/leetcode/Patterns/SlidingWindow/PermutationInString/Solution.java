package main.com.think101.leetcode.Patterns.SlidingWindow.PermutationInString;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> cnt = new HashMap<>();

        for(int i = 0; i < s1.length(); i++) {
            if(!cnt.containsKey(s1.charAt(i)))
                cnt.put(s1.charAt(i), 0);

            cnt.put(s1.charAt(i), cnt.get(s1.charAt(i)) + 1);
        }

        for(int i = 0; i < s2.length(); i++) {
            char c = s2.charAt(i);
            if(cnt.containsKey(c)) {
                if(checkRange(s2, i, s1.length(), cnt))
                    return true;
            }
        }

        return false;
    }

    private boolean checkRange(String s, int i, int len, Map<Character, Integer> cnt) {
        Map<Character, Integer> currCnt = new HashMap<>();
        for(int j = i; j < i + len; j++) {
            if(!currCnt.containsKey(s.charAt(j)))
                cnt.put(s.charAt(j), 0);

            currCnt.put(s.charAt(j), currCnt.get(s.charAt(j)) + 1);
        }

        return false;
    }
}