package main.com.think101.leetcode.contest.Test297.NamingACompany;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public long distinctNames(String[] ideas) {
        Map<String, List<String>> suffixToStr = new HashMap<>();
        Map<Character, List<String>> firstCharToStr = new HashMap<>();

        for(String s : ideas){
            String suffix = s.substring(1);
            if(!suffixToStr.containsKey(suffix)){
                suffixToStr.put(suffix, new ArrayList<>());
            }
            suffixToStr.get(suffix).add(s);

            if(!firstCharToStr.containsKey(s.charAt(0))){
                firstCharToStr.put(s.charAt(0), new ArrayList<>());
            }
            firstCharToStr.get(s.charAt(0)).add(s);
        }

        int res = 0;
        for(String s : ideas){
            List<Character> skipChars = new ArrayList<>();

            for(String t : suffixToStr.get(s.substring(1))){
                if(!s.equals(t)){
                    skipChars.add(t.charAt(0));
                }
            }

            for(Character c : firstCharToStr.keySet()){
                if(!skipChars.contains(c)){
                    res += firstCharToStr.get(c).size();
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.distinctNames(new String[]{"coffee", "donuts", "time", "toffee"}));
    }
}
