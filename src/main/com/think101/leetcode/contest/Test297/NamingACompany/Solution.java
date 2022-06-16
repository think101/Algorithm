package main.com.think101.leetcode.contest.Test297.NamingACompany;

import java.util.*;

class Solution {
    public long distinctNames(String[] ideas) {
        Map<String, List<Character>> suffixToFirstChars = new HashMap<>();
        Map<Character, List<String>> firstCharToStrs = new HashMap<>();

        for(String s : ideas){
            String suffix = s.substring(1);
            if(!suffixToFirstChars.containsKey(suffix)){
                suffixToFirstChars.put(suffix, new ArrayList<>());
            }
            suffixToFirstChars.get(suffix).add(s.charAt(0));

            if(!firstCharToStrs.containsKey(s.charAt(0))){
                firstCharToStrs.put(s.charAt(0), new ArrayList<>());
            }
            firstCharToStrs.get(s.charAt(0)).add(s);
        }

        int res = 0;
        for(String s : ideas){
            List<Character> skipChars = suffixToFirstChars.get(s.substring(1));
            for(Character c : firstCharToStrs.keySet()){
                if(!skipChars.contains(c)){
                    for(String str : firstCharToStrs.get(c)) {
                        if(!suffixToFirstChars.get(str.substring(1)).contains(s.charAt(0))) {
                            res += 1;
                        }
                    }
                }
                else if(c == s.charAt(0)) {
                    for(String str : firstCharToStrs.get(c)) {
                        if(str.charAt(0) != c) {
                            res += 1;
                        }
                    }
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.distinctNames(new String[]{"coffee", "donuts", "time", "toffee"}));

        System.out.println(s.distinctNames(new String[]{"lack", "back"}));
    }
}
