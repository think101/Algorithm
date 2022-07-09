package main.com.think101.leetcode.Patterns.BackTrack.SplittingStrDescConseValues;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean splitString(String s) {
        return dfs(s, 0, new ArrayList<>());
    }

    private boolean dfs(String s, int i, List<BigInteger> substrs) {
        if (i == s.length() && substrs.size() > 1) {
            return true;
        }

        for(int j = i; j < s.length(); j++) {
            BigInteger substrInt = new BigInteger(s.substring(i, j+1));
            if(substrs.size() == 0 || substrs.get(substrs.size() - 1).subtract(substrInt).equals(BigInteger.ONE)) {
                substrs.add(substrInt);
                if(dfs(s, j+1, substrs))
                    return true;
                substrs.remove(substrs.size() - 1);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.splitString("12345"));
        System.out.println(s.splitString("050043"));
        System.out.println(s.splitString("3202872336"));
        System.out.println(s.splitString("64424509442147483647"));
    }
}