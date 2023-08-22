package main.com.think101.leetcode.Patterns.Other.ExcelSheetColumnTitle;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String convertToTitle(int c) {
        Map<Integer, Character> m = new HashMap<>();
        for(int i = 1; i <= 26; i++) {
            m.put(i, (char)('A' + i - 1));
        }

        StringBuilder sb = new StringBuilder();
        while(c > 26) {
            int mod = c % 26;
            c = (int)(c * 1.0 / 26);

            if(mod == 0) {
                mod = 26;
                c = c - 1;
            }

            sb.insert(0, m.get(mod));
        }

        if(c > 0) {
            sb.insert(0, m.get(c));
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.convertToTitle(701));
    }

}
