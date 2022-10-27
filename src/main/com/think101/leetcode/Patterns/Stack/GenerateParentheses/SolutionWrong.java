package main.com.think101.leetcode.Patterns.Stack.GenerateParentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolutionWrong {
    public List<String> generateParenthesis(int n) {
        List<List<String>> dp = new ArrayList<>();

        List<String> init = new ArrayList<>();
        init.add("");
        dp.add(init);

        for(int i = 1; i <= n; i++) {
            List<String> p = dp.get(i-1);

            Set<String> curr = new HashSet<>();
            for(String s : p) {
                curr.add("()" + s);
                curr.add(s + "()");
                curr.add("(" + s + ")");
            }

            dp.add(new ArrayList<>(curr));
        }

        return dp.get(n);
    }

    public static void main(String[] args) {
        SolutionWrong s = new SolutionWrong();
        System.out.println(s.generateParenthesis(3));
    }
}
