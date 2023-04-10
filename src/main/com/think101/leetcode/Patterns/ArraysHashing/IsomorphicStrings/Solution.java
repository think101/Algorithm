package main.com.think101.leetcode.Patterns.ArraysHashing.IsomorphicStrings;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(t.charAt(i) != map.get(s.charAt(i))) return false;
            }
            else {
                if(map.containsValue(t.charAt(i))) return false;   // two chars pointing to same char
                map.put(s.charAt(i), t.charAt(i));
            }
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
