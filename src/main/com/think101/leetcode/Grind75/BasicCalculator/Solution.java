package main.com.think101.leetcode.Grind75.BasicCalculator;

import java.util.Stack;

public class Solution {
    public int calculate(String s) {
        s = s.replaceAll("\\s+", "");

        Stack<String> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '-') {
                // - char bind with the char(s) after it
                if(stack.empty() || !Character.isDigit(stack.peek().charAt(0))) {
                    int end = getNumber(s, i);
                    stack.push(s.substring(i, end+1));
                    i = end;
                }
                else {
                    stack.push(s.substring(i, i+1));
                }
            }
            else if(s.charAt(i) == '+' || s.charAt(i) == '('){
                stack.push(s.substring(i, i+1));
            }
            else if(s.charAt(i) == ')') {
                String t = stack.pop();
                stack.pop();    // pop '('
                stack.push(t);
            }
            else {
                // a number
                int end = getNumber(s, i);
                int n = Integer.valueOf(s.substring(i, end+1));

                if(!stack.empty() && (stack.peek().charAt(0) == '+' || stack.peek().charAt(0) == '-')) {
                    String op = stack.pop();
                    int prevNum = Integer.valueOf(stack.pop());

                    if(op.equals("+")) {
                        stack.push(String.valueOf(prevNum + n));
                    }
                    else{
                        stack.push(String.valueOf(prevNum - n));
                    }
                }
                else {
                    stack.push(String.valueOf(n));
                }

                i = end;
            }
        }

        return Integer.valueOf(stack.pop());
    }

    private int getNumber(String s, int start) {
        int end = start;
        while(end < s.length() && Character.isDigit(s.charAt(end))) {
            end++;
        }

        return end-1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
