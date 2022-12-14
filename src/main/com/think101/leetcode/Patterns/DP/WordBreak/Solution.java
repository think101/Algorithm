package main.com.think101.leetcode.Patterns.DP.WordBreak;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        Set<Integer> breakIndex = new HashSet<>();
        breakIndex.add(-1);

        Set<String> words = new HashSet<>(wordDict);

        for(int i = 0; i < len; i++) {
            boolean canBreak = false;
            for(int j : breakIndex) {
                if(words.contains(s.substring(j + 1, i + 1))) {
                    canBreak = true;
                    break;
                }
            }

            if(canBreak){
                breakIndex.add(i);
            }
        }

        return breakIndex.contains(len - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.wordBreak("leetcode", List.of("leet", "code")));
        System.out.println(s.wordBreak("applepenapple", List.of("apple", "pen")));
        System.out.println(s.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }
}
