package main.com.think101.leetcode.Patterns.DP.WordBreak;

import java.util.List;

public class Solution_TLE {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        int[] canBreak = new int[len + 1];
        canBreak[len] = 1;

        for(int i = len - 1; i >= 0; i--) {
            String t = s.substring(i);

            for(String word : wordDict) {
                if(t.startsWith(word) && canBreak[i + word.length()] == 1){
                    canBreak[i] = 1;
                    break;
                }
            }
        }

        return canBreak[0] == 1;
    }

    public static void main(String[] args) {
        Solution_TLE s = new Solution_TLE();
        System.out.println(s.wordBreak("leetcode", List.of("leet", "code")));
        System.out.println(s.wordBreak("applepenapple", List.of("apple", "pen")));
        System.out.println(s.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }
}
