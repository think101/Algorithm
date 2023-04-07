package main.com.think101.leetcode.Patterns.ArraysHashing.ReorganizeString;

import java.util.*;

public class Solution {
    public String reorganizeString(String s) {
        TreeMap<Integer, List<Character>> cntToChars = new TreeMap<>(Comparator.reverseOrder());
        int[] cnts = new int[26];

        for(int i = 0; i < s.length(); i++) {
            cnts[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            if(cnts[i] == 0) continue;

            if(!cntToChars.containsKey(cnts[i])){
                cntToChars.put(cnts[i], new ArrayList<>());
            }

            cntToChars.get(cnts[i]).add((char)('a' + i));
        }

        if(cntToChars.firstKey() - 1 > s.length() - cntToChars.firstKey()) return "";

        StringBuilder sb = new StringBuilder();
        char curr = '1';

        while(sb.length() < s.length()) {
            boolean appended = false;

            Iterator<Integer> it = cntToChars.keySet().iterator();
            Map<Integer, Character> insert = new HashMap<>();

            while (it.hasNext()) {
                int key = it.next();
                List<Character> chars = cntToChars.get(key);
                for(int i = 0; i < chars.size(); i++) {
                    if(chars.get(i) != curr) {
                        char c = chars.get(i);
                        sb.append(c);
                        curr = c;
                        chars.remove(i);

                        if(key > 1) {
                            if(!cntToChars.containsKey(key - 1)) {
                                insert.put(key - 1, c);
                            }
                            else {
                                cntToChars.get(key - 1).add(c);
                            }
                        }

                        appended = true;
                        break;
                    }
                }

                if(appended) break;
            }

            for(Map.Entry<Integer, Character> entry : insert.entrySet()) {
                if(!cntToChars.containsKey(entry.getKey())) {
                    cntToChars.put(entry.getKey(), new ArrayList<>());
                }
                cntToChars.get(entry.getKey()).add(entry.getValue());
            }

            if(!appended) return "";
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.reorganizeString("kkkkzrkatkwpkkkktrq"));
    }
}