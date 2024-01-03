package main.com.think101.leetcode.Patterns.ArraysHashing.ValidAnagram;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> cnt = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!cnt.containsKey(c)) cnt.put(c, 0);
            cnt.put(c, cnt.get(c) + 1);
        }

        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(!cnt.containsKey(c)) return false;
            if(cnt.get(c) == 1) {
                cnt.remove(c);
                continue;
            }

            cnt.put(c, cnt.get(c) - 1);
        }

        return cnt.isEmpty();
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.isAnagram("anagram", "nagaram"));
        System.out.println(s.isAnagram("rat", "car"));
    }
}
