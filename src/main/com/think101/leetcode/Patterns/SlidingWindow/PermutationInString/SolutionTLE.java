package main.com.think101.leetcode.Patterns.SlidingWindow.PermutationInString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionTLE {
    public boolean checkInclusion(String s1, String s2) {
        List<String> perms = permutations(s1);
        for(String perm : perms) {
            if(s2.contains(perm)) return true;
        }

        return false;
    }

    private List<String> permutations(String s) {
        List<String> res = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            Set<Integer> visited = new HashSet<>();
            visited.add(i);
            StringBuilder sb = new StringBuilder();
            sb.append(s.charAt(i));
            bt(res, visited, sb, s);
        }

        return res;
    }

    private void bt(List<String> res, Set<Integer> visited, StringBuilder sb, String s) {
        if(sb.length() == s.length()) {
            res.add(sb.toString());
            return;
        }

        for(int i = 0; i < s.length(); i++) {
            if(!visited.contains(i)) {
                visited.add(i);
                sb.append(s.charAt(i));

                bt(res, visited, sb, s);

                visited.remove(i);
                sb.setLength(sb.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        SolutionTLE s = new SolutionTLE();
        System.out.println(s.checkInclusion("abc", "eidbaooo"));
    }
}
