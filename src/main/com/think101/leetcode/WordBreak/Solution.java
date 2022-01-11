package main.com.think101.leetcode.WordBreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        return wordBreak(s, wordSet);
    }

    public boolean wordBreak(String s, Set<String> wordSet) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int i=1; i<=s.length(); i++) {
            for(int j=0; j<i; j++) {
                if(dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }

            }
        }

        return dp[s.length()];
    }



    public boolean wordBreak_Still_TLE(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);

        if(wordDict.contains(s))
            return true;

        int l = Math.min(s.length(),20);
        for(int i=1; i<l; i++) {
            if(wordSet.contains(s.substring(0, i)) && wordBreak_Still_TLE(s.substring(i), wordDict))
                return true;
        }

        return false;
    }


    public boolean wordBreak_recursive(String s, List<String> wordDict) {
        if(wordDict.contains(s))
            return true;

        for(String w : wordDict) {
            if(s.startsWith(w)) {
                boolean res = wordBreak_recursive(s.substring(w.length()), wordDict);
                if(res)
                    return true;
            }
        }

        return false;
    }

}
