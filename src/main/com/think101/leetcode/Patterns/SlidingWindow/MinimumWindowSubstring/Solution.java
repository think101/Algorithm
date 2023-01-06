package main.com.think101.leetcode.Patterns.SlidingWindow.MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tCnt = new HashMap<>();
        Map<Character, Integer> sCnt = new HashMap<>();
        int need = 0, have = 0, start = 0, end = 0;
        String res = "";

        for(int i = 0; i < t.length(); i++) {
            if(!tCnt.containsKey(t.charAt(i))){
                tCnt.put(t.charAt(i), 0);
            }

            tCnt.put(t.charAt(i), tCnt.get(t.charAt(i)) + 1);
        }
        need = tCnt.size();

        while(end < s.length()) {
            char c = s.charAt(end);
            if(!tCnt.containsKey(c)) continue;

            if(!sCnt.containsKey(c)) sCnt.put(c, 0);
            sCnt.put(c,sCnt.get(c) + 1);

            if(Objects.equals(sCnt.get(c), tCnt.get(c))) have++;
            while(have >= need) {
                if("".equals(res) || end - start + 1 < res.length()) res = s.substring(start, end + 1);

                start++;
                char remove = s.charAt(start - 1);
                if(!sCnt.containsKey(remove)) continue;

                sCnt.put(c, tCnt.get(c) - 1);
                if(sCnt.get(remove) < tCnt.get(remove)) have--;
            }
        }

        return res;
    }
}
