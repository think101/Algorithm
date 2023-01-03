package main.com.think101.leetcode.Patterns.SlidingWindow.LongestRepeatingCharacterReplacement;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public int characterReplacement(String s, int k) {
        TreeMap<Character, Integer> charCnt = new TreeMap<>();
        int l = 0, r = 0;
        int res = 0;

        charCnt.put(s.charAt(0), 1);

        while(l < s.length() && r < s.length()) {
            //if(r - l + 1 < res) break;

            int maxCnt = getMaxValueEntry(charCnt).getValue();
            int curr = r - l + 1;

            if(curr - maxCnt <= k) {
                res = Math.max(res, curr);
                r++;

                if(r < s.length()) {
                    if(!charCnt.containsKey(s.charAt(r))) {
                        charCnt.put(s.charAt(r), 0);
                    }

                    charCnt.put(s.charAt(r), charCnt.get(s.charAt(r)) + 1);
                }
            }
            else {
                l++;

                if(charCnt.get(s.charAt(l-1)).equals(1)) {
                    charCnt.remove(s.charAt(l-1));
                }
                else {
                    charCnt.put(s.charAt(l-1), charCnt.get(s.charAt(l-1)) - 1);
                }
            }
        }

        return res;

    }

    private Map.Entry<Character, Integer> getMaxValueEntry(TreeMap<Character, Integer> charCnt) {
        Map.Entry<Character, Integer> maxEntry = null;
        for(Map.Entry<Character, Integer> entry : charCnt.entrySet()) {
            if(maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                maxEntry = entry;
            }
        }

        return maxEntry;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.characterReplacement("KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF", 4));
        //System.out.println(solution.characterReplacement("AABABBA", 1));
    }
}