package main.com.think101.leetcode.Patterns.BackTrack.LetterCombinationsOfAPhoneNumber;

import java.util.*;

public class Solution {
    private static final Map<Character, List<String>> numToChars = new HashMap<>();
    static {
        numToChars.put('2', Arrays.asList("a", "b", "c"));
        numToChars.put('3', Arrays.asList("d", "e", "f"));
        numToChars.put('4', Arrays.asList("g", "h", "i"));
        numToChars.put('5', Arrays.asList("j", "k", "l"));
        numToChars.put('6', Arrays.asList("m", "n", "o"));
        numToChars.put('7', Arrays.asList("p", "q", "r", "s"));
        numToChars.put('8', Arrays.asList("t", "u", "v"));
        numToChars.put('9', Arrays.asList("w", "x", "y", "z"));
    }

    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        bt(digits, 0, "");
        return res;
    }

    private void bt(String digits, int i, String curr) {
        if(i >= digits.length()) {
            if(curr.length() > 0)
                res.add(curr);
            return;
        }

        List<String> chars = numToChars.get(digits.charAt(i));
        for(String s : chars) {
            curr += s;
            bt(digits, i + 1, curr);
            curr = curr.substring(0, curr.length() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.letterCombinations("23"));
    }
}
