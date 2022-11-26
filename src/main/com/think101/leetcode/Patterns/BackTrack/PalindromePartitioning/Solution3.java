package main.com.think101.leetcode.Patterns.BackTrack.PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        bt(s, 0, new ArrayList<>());
        return res;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    private void bt(String s, int i, List<String> curr) {
        if(i == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int j = i+1; j <= s.length(); j++) {
            String t = s.substring(i, j);
            curr.add(t);
            if(isPalindrome(s.substring(i, j))) {
                bt(s, j, curr);
            }
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        List<List<String>> res = sol.partition("aab");
        for(List<String> list : res) {
            for(String s : list)
                System.out.print(s + " ");
            System.out.println();
        }
    }
}
