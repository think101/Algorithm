package main.com.think101.leetcode.Patterns.Stack.ValidParentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> q = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[')
                q.push(c);
            else {
                if(q.size() == 0) return false;

                char t = q.pop();

                if((t == '(' && c != ')')
                        || (t == '[' && c != ']')
                        || (t == '{' && c != '}')) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("([)]"));
    }
}