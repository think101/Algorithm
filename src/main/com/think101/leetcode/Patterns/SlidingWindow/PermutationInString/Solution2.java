package main.com.think101.leetcode.Patterns.SlidingWindow.PermutationInString;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> s1Cnt = new HashMap<>();
        Map<Character, Integer> s2Cnt = new HashMap<>();
        int matches = 0;

        for(int i = 0; i < 26; i++) {
            s1Cnt.put((char)('a' + i), 0);
            s2Cnt.put((char)('a' + i), 0);
        }

        for(int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            s1Cnt.put(c, s1Cnt.get(c) + 1);
        }

        for(int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            s2Cnt.put(c, s2Cnt.get(c) + 1);
        }

        for(int i = 0; i < 26; i++) {
            if(s1Cnt.get((char)('a' + i)) == s2Cnt.get((char)('a' + i))) matches++;
            else matches--;
        }

        int i = s1.length();
        while(matches != 26 && i < s2.length()) {
            char in = s2.charAt(i);
            char out = s2.charAt(i - s1.length());

            s2Cnt.put(out, s2Cnt.get(out) - 1);
            s2Cnt.put(in, s2Cnt.get(in) + 1);

            if(s2Cnt.get(out) == s1Cnt.get(out)) matches++;
            else matches--;

            if(s2Cnt.get(in) == s1Cnt.get(in)) matches++;
            else matches--;

            i++;
        }

        return matches == 26;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.checkInclusion("ab", "eidbaooo"));
    }
}
