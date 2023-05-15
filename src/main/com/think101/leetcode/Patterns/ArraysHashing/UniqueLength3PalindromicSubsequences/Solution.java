package main.com.think101.leetcode.Patterns.ArraysHashing.UniqueLength3PalindromicSubsequences;

import java.util.*;

public class Solution {
    public int countPalindromicSubsequence(String s) {
        Map<Character, Integer> charCnt = new HashMap<>();
        List<Set<Character>> positionCharSet = new ArrayList<>();
        Set<String> res = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            charCnt.put(s.charAt(i), charCnt.getOrDefault(s.charAt(i), 0) + 1);
        }

        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if(charCnt.get(c) == 1) charCnt.remove(c);
            else charCnt.put(c, charCnt.get(c) - 1);

            positionCharSet.add(0, charCnt.keySet());
        }

        for(int i = 0; i < s.length() - 3; i++) {
            for(int j = i + 1; j < s.length() - 2; j++) {
                if(positionCharSet.get(j + 1).contains(s.charAt(i))) {
                    res.add(String.valueOf(s.charAt(i)) + s.charAt(j) + s.charAt(i));
                }
            }
        }

        return res.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countPalindromicSubsequence("aabca"));
    }
}
