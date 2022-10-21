package main.com.think101.leetcode.Patterns.Stack.ValidParentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[')
                stack.push(c);
            else {
                if(stack.size() == 0) return false;

                char t = stack.pop();

                if((t == '(' && c != ')')
                        || (t == '[' && c != ']')
                        || (t == '{' && c != '}')) {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("([)]"));
    }
}