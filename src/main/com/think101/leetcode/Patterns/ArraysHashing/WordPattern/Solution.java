package main.com.think101.leetcode.Patterns.ArraysHashing.WordPattern;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> pToStr = new HashMap<>();
        String[] strs = s.split(" ");

        if(strs.length != pattern.length()) return false;

        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if(pToStr.containsKey(c)) {
                if(!pToStr.get(c).equals(strs[i])) return false;
            }
            else {
                if(pToStr.containsValue(strs[i])) return false;
                pToStr.put(c, strs[i]);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String pattern = "abba";
        String str = "dog cat cat dog";
        System.out.println(s.wordPattern(pattern, str));
    }
}
