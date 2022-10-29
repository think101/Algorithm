package main.com.think101.leetcode.Patterns.Stack.EvaluateReversePolishNotation;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int b = Integer.parseInt(stack.pop()), a = Integer.parseInt(stack.pop());
                switch (token) {
                    case "+" -> stack.push(String.valueOf(a + b));
                    case "-" -> stack.push(String.valueOf(a - b));
                    case "*" -> stack.push(String.valueOf(a * b));
                    default -> stack.push(String.valueOf(a / b));
                }
            } else {
                stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.evalRPN(new String[]{"2", "1", "+", "3", "*"}));

        System.out.println(-11);
    }
}
