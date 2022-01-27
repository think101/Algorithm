package main.com.think101.leetcode.GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        helper(result, "", n, 0);

        return result;
    }

    private void helper(List<String> result, String s, int l, int r) {
        if(l==0 && r == 0){
            result.add(s);
            return;
        }

        if(l>0)
            helper(result, s + "(", l-1, r+1);

        if(r>0)
            helper(result, s+ ")", l, r-1);
    }
}
