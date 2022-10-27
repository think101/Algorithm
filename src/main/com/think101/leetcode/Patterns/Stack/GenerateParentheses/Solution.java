package main.com.think101.leetcode.Patterns.Stack.GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(res, "", n, n);
        return res;
    }

    private void dfs(List<String> res, String s, int left, int right) {
        if(left == 0 && right == 0) {
            res.add(s);
            return;
        }

        if(left > 0) dfs(res, s + "(", left - 1, right);
        if(right > left) dfs(res, s + ")", left, right - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generateParenthesis(4));
    }
}
