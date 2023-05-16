package main.com.think101.leetcode.Patterns.ArraysHashing.UniqueLength3PalindromicSubsequences;

import java.util.*;

public class Solution {
    public int countPalindromicSubsequence(String s) {
        Map<Character, Integer> charCnt = new HashMap<>();
        Map<Character, Integer> charCntDup = new HashMap<>();

        // chars after this position
        List<Set<Character>> afterPosCharSet = new ArrayList<>();
        // chars before this position
        List<Set<Character>> beforePosCharSet = new ArrayList<>();


        Set<String> res = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            charCnt.put(s.charAt(i), charCnt.getOrDefault(s.charAt(i), 0) + 1);
        }
        charCntDup = new HashMap<>(charCnt);

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(charCnt.get(c) == 1) charCnt.remove(c);
            else charCnt.put(c, charCnt.get(c) - 1);
            afterPosCharSet.add(new HashSet<>(charCnt.keySet()));

            c = s.charAt(s.length() - 1 - i);
            if(charCntDup.get(c) == 1) charCntDup.remove(c);
            else charCntDup.put(c, charCntDup.get(c) - 1);
            beforePosCharSet.add(0, new HashSet<>(charCntDup.keySet()));
        }

        for(int i = 1; i < s.length() - 1; i++) {
            Set<Character> bpSet = beforePosCharSet.get(i);
            Set<Character> apSet = afterPosCharSet.get(i);
            for(int j = 0; j < 26; j++) {
                char c = (char)('a' + j);
                if(bpSet.contains(c) && apSet.contains(c)) {
                    res.add(c + "" + s.charAt(i) + c);
                }
            }
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
