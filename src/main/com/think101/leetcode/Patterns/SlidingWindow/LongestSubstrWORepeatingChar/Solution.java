package main.com.think101.leetcode.Patterns.SlidingWindow.LongestSubstrWORepeatingChar;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> charPos = new HashMap<>();
        int start = 0, res = 0;

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // this char already exists
            if(charPos.containsKey(c)) {
                int p = charPos.get(c);
                for(int j = start; j <= p; j++) {
                    charPos.remove(s.charAt(j));
                }
                start = p + 1;
            }

            charPos.put(c, i);
            res = Math.max(res, charPos.size());
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring("bpfbhmipx"));
    }
}