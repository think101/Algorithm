package main.com.think101.leetcode.Patterns.ArraysHashing.UniqueLength3PalindromicSubsequences;

import java.util.*;

public class Solution {
    public int countPalindromicSubsequence(String s) {
        Map<Character, Integer> charCnt = new HashMap<>();

        Set<String> res = new HashSet<>();
        Set<Character> left = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            charCnt.put(s.charAt(i), charCnt.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            if(charCnt.get(c) == 1) charCnt.remove(c);
            else charCnt.put(c, charCnt.get(c) - 1);

            for(int j = 0; j < 26; j++) {
                char t = (char)('a' + j);
                if(charCnt.containsKey(t) && left.contains(t)) {
                    res.add(t + "" + s.charAt(i) + t);
                }
            }

            left.add(c);
        }

        return res.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countPalindromicSubsequence("aabca"));
        System.out.println(s.countPalindromicSubsequence("adc"));
        System.out.println(s.countPalindromicSubsequence("bbcbaba"));
    }
}
