package main.com.think101.leetcode.Patterns.BackTrack.PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<List<String>> allSubSet = new ArrayList<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        bt(s, 0, new ArrayList<>());

        for(List<String> l : allSubSet) {
            if(allPalindrome(l)) {
                res.add(l);
            }
        }

        return res;
    }

    private boolean allPalindrome(List<String> strs) {
        for(String s : strs){
            if(!isPalindrome(s)){
                return false;
            }
        }

        return true;
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
            allSubSet.add(new ArrayList<>(curr));
            return;
        }

        if(curr.size() == 0) {
            curr.add(s.substring(i, i+1));
            bt(s, i+1, curr);
            curr.remove(curr.size() - 1);
        }
        else {
            String last = curr.get(curr.size() - 1);
            curr.remove(curr.size() - 1);
            curr.add(last + s.charAt(i));
            bt(s, i+1, curr);

            curr.remove(curr.size() - 1);
            curr.add(last);
            curr.add(s.substring(i, i+1));
            bt(s, i+1, curr);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        List<List<String>> res = sol.partition("aab");
        for(List<String> list : res) {
            for(String s : list)
                System.out.print(s + " ");
            System.out.println();
        }
    }
}
