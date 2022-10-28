package main.com.think101.leetcode.Patterns.Stack.GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class SolutionBT {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack("", 0, 0, n);

        return res;
    }

    private void backtrack(String s, int leftCnt, int rightCnt, int n) {
        if(leftCnt == n && rightCnt == n) {
            res.add(s);
            return;
        }

        if(leftCnt < n) {
            s = s + "(";
            backtrack(s, leftCnt+1, rightCnt, n);
            s = s.substring(0, s.length() - 1);
        }

        if(leftCnt > rightCnt) {
            s = s + ")";
            backtrack(s, leftCnt, rightCnt+1, n);
        }
    }

    public static void main(String[] args) {
        SolutionBT s = new SolutionBT();
        System.out.println(s.generateParenthesis(4));
    }
}
