package main.com.think101.leetcode.Patterns.DP.WordBreak;

import java.util.List;

public class Solution_TLE {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s.length() == 0) return true;

        for(String word : wordDict) {
            if(s.startsWith(word)) {
                boolean b = wordBreak(s.substring(word.length()), wordDict);
                if(b) return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution_TLE s = new Solution_TLE();
        System.out.println(s.wordBreak("leetcode", List.of("leet", "code")));
        System.out.println(s.wordBreak("applepenapple", List.of("apple", "pen")));
        System.out.println(s.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }
}
