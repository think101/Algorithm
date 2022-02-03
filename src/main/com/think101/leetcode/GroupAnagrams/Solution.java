package main.com.think101.leetcode.GroupAnagrams;

import java.util.*;

public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for(String s : strs) {
            int[] cnt = new int[26];
            for(int i=0; i<s.length(); i++) {
                cnt[s.charAt(i)-'a']++;
            }

            String key = Arrays.toString(cnt);
            if(!anagrams.containsKey(key)) {
                List<String> l = new ArrayList<>();
                anagrams.put(key, l);
            }

            anagrams.get(key).add(s);
        }

        return new ArrayList<>(anagrams.values());
    }
}
