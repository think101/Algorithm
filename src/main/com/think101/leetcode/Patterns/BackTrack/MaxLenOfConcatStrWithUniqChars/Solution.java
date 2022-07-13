package main.com.think101.leetcode.Patterns.BackTrack.MaxLenOfConcatStrWithUniqChars;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {

    private int res = 0;

    public int maxLength(List<String> arr) {
        Set<Character> currChars = new HashSet<>();

        dfs(arr, 0, currChars);
        return res;
    }

    private void dfs(List<String> arr, int i, Set<Character> currChars) {
        if(i == arr.size()) {
            return;
        }

        for(int j = i; j < arr.size(); j++) {
            String t = arr.get(j);
            if(isUniq(currChars, t)) {
                for(int k = 0; k < t.length(); k++)
                    currChars.add(t.charAt(k));

                res = Math.max(res, currChars.size());
                dfs(arr, j+1, currChars);

                for(int k = 0; k < t.length(); k++)
                    currChars.remove(t.charAt(k));
            }
        }
    }

    private boolean isUniq(Set<Character> currChars, String s) {
        Set<Character> charS = new HashSet<>();     // check duplicate for s itself

        for(int i = 0; i < s.length(); i++) {
            if(currChars.contains(s.charAt(i)) || charS.contains(s.charAt(i)))
                return false;

            charS.add(s.charAt(i));
        }

        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxLength(List.of("abc", "ae")));
    }
}
