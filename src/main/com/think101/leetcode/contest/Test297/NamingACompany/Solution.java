package main.com.think101.leetcode.contest.Test297.NamingACompany;

import java.util.*;

class Solution {
    public long distinctNames(String[] ideas) {
        Map<Character, Set<String>> firstCharToSuffixes = new HashMap<>();

        for(String s : ideas){
            if(!firstCharToSuffixes.containsKey(s.charAt(0))){
                firstCharToSuffixes.put(s.charAt(0), new HashSet<>());
            }
            firstCharToSuffixes.get(s.charAt(0)).add(s.substring(1));
        }

        long res = 0;
        List<Character> allFirstChars = new ArrayList<>(firstCharToSuffixes.keySet());
        for(int i = 0; i < allFirstChars.size(); i++) {
            for(int j = i+1; j < allFirstChars.size(); j++) {
                long c1 = 0, c2 = 0;

                for(String suffix : firstCharToSuffixes.get(allFirstChars.get(i))) {
                    if(!firstCharToSuffixes.get(allFirstChars.get(j)).contains(suffix))
                        c1++;
                }

                for(String suffix : firstCharToSuffixes.get(allFirstChars.get(j))) {
                    if(!firstCharToSuffixes.get(allFirstChars.get(i)).contains(suffix))
                        c2++;
                }

                res += c1 * c2;
            }
        }

        return res * 2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.distinctNames(new String[]{"coffee", "donuts", "time", "toffee"}));

        System.out.println(s.distinctNames(new String[]{"lack", "back"}));
    }
}
