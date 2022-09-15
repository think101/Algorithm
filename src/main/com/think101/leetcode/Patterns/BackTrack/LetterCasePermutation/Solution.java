package main.com.think101.leetcode.Patterns.BackTrack.LetterCasePermutation;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        List<Character> visited = new ArrayList<>();
        bt(visited, 0, s);

        return res;
    }

    private void bt(List<Character> visited, int i, String s) {
        if(i == s.length()){
            StringBuilder sb = new StringBuilder();
            for(char c : visited){
                sb.append(c);
            }

            res.add(sb.toString());
            return;
        }

        char c = s.charAt(i);
        if(c - '0' >= 0 && c - '0' <= 9){
            visited.add(c);
            bt(visited, i+1, s);
            visited.remove(visited.size() - 1);
        }
        else {
            visited.add(Character.toLowerCase(c));
            bt(visited, i+1, s);
            visited.remove(visited.size() - 1);

            visited.add(Character.toUpperCase(c));
            bt(visited, i+1, s);
            visited.remove(visited.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCasePermutation("a1b2"));
    }
}
