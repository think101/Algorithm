package main.com.think101.leetcode.LetterCombinationsofaPhoneNumber;

import java.util.*;

public class Solution {

    private static final Map<String, List<String>> digitToLetter = new HashMap<String, List<String>>() {{
        put("2", Arrays.asList("a", "b", "c"));
        put("3", Arrays.asList("d", "e", "f"));
        put("4", Arrays.asList("g", "h", "i"));
        put("5", Arrays.asList("j", "k", "l"));
        put("6", Arrays.asList("m", "n", "o"));
        put("7", Arrays.asList("p", "q", "r", "s"));
        put("8", Arrays.asList("t", "u", "v"));
        put("9", Arrays.asList("w", "x", "y", "z"));
    }};

    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.isEmpty())
            return new ArrayList<>();

        if(digits.length() == 1)
            return digitToLetter.get(digits);

        String c = digits.substring(0,1);
        List<String> res = letterCombinations(digits.substring(1));

        List<String> ans = new ArrayList<>();
        for(String r : res) {
            for(String letter : digitToLetter.get(c)) {
                ans.add(letter + r);
            }
        }

        return ans;
    }
}
