package main.com.think101.leetcode.Patterns.BackTrack.SplittingStrDescConseValues;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean splitString(String s) {
        return dfs(s, 0, new ArrayList<>());
    }

    private boolean dfs(String s, int i, List<Integer> substrs) {
        if (i == s.length() && substrs.size() > 1) {
            return true;
        }

        for(int j = i; j < s.length(); j++) {
            int substrInt = Integer.parseInt(s.substring(i, j+1));
            if(substrs.size() == 0 || substrInt - substrs.get(substrs.size() - 1) == -1) {
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
    }
}