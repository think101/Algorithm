package main.com.think101.leetcode.Patterns.Stack.CheckIfAParenthesesStringCanBeValid;

import java.util.Stack;

public class Solution {
    public boolean canBeValid(String s, String locked) {
        int len = s.length();
        Stack<Character> stack = new Stack<>();
        int lockChars = 0;

        for(int i = 0; i < len; i++) {
            if(locked.charAt(i) == '1'){
                if(s.charAt(i) == ')') {
                    if((stack.size() == 0 || (stack.peek() != '(' && stack.peek() != '1'))) return false;
                    else {
                        if(stack.peek() == '(') lockChars--;
                        stack.pop();
                    }
                }
                else {
                    stack.push(s.charAt(i));
                    lockChars++;
                }
            }
            else {
                if(stack.size() > 0 && stack.peek() == '(') {
                    stack.pop();
                    lockChars--;
                }
                else stack.push('1');
            }
        }

        return stack.size() % 2 == 0 && lockChars == 0;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.canBeValid("((()(()())", "1011110010"));
    }
}