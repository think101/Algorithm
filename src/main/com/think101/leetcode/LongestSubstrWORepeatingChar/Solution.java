package main.com.think101.leetcode.LongestSubstrWORepeatingChar;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1)
            return s.length();

        int i = 0;
        int j;
        int res = 0;
        Map<Character, Integer> chars = new HashMap<>();
        chars.put(s.charAt(0), 0);

        for(j = 1; j < s.length(); j++){
            if(chars.containsKey(s.charAt(j))) {
                int ind = chars.get(s.charAt(j));

                for(int k = i; k <= ind; k++){
                    chars.remove(s.charAt(k));
                }

                i = ind + 1;
            }

            chars.put(s.charAt(j), j);

            res = Math.max(res, j - i + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));

        s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));

        s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
